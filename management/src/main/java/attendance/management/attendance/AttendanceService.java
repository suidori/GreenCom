package attendance.management.attendance;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserAndLectureRepository userAndLectureRepository;

    public Attendance unlogged(AttendanceReqDto attendanceReqDto) {

        Attendance attendance = modelMapper.map(attendanceReqDto, Attendance.class);

        Optional<User> user = userRepository.findByNameAndPhoneNumber(attendanceReqDto.getUser().getName(), attendanceReqDto.getUser().getPhoneNumber());
        user.ifPresentOrElse(
                attendance::setUser,
                () -> new BizException(ErrorCode.USER_NOT_FOUND)
        );

        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser(attendance.getUser());
        userAndLecture.ifPresentOrElse(
                userAndLecture1 -> attendance.setLecture(userAndLecture1.getLecture()),
                () -> new BizException(ErrorCode.LECTURE_NOT_FOUND)
        );

        attendance.setTeacheraccept(false);
        attendance.setManageraccept(false);

        attendanceRepository.save(attendance);

        return attendance;

    }

    public AttendanceResponsePageDto studentPage(Pageable pageable, AttendanceReqDto attendanceReqDto) {
        Page<Attendance> page = attendanceRepository.findAll(pageable);

        AttendanceResponsePageDto attendanceResponsePageDto = modelMapper.map(page, AttendanceResponsePageDto.class);

        Optional<User> fuser = userRepository.findById(attendanceReqDto.getUser().getIdx());

        if (fuser.isEmpty()) {
            new BizException(ErrorCode.USER_NOT_FOUND);
        }

        Optional<UserAndLecture> ual = userAndLectureRepository.findByUser(fuser.get());

        if (ual.isEmpty()) {
            new BizException(ErrorCode.USER_NOT_FOUND);
        }

        List<AttendanceResponseDto> list = attendanceResponsePageDto
                .getContent()
                .stream()
                .filter(attendance -> attendance.getLecture().getIdx().equals(ual.get().getLecture().getIdx()))
                .map(attendance -> {
                    AttendanceResponseDto attendanceResponseDto = modelMapper.map(attendance, AttendanceResponseDto.class);
                    if (attendance.isTeacheraccept()) {
                        attendanceResponseDto.setTeacheraccept("담당교사 확인 완료");
                    } else {
                        attendanceResponseDto.setTeacheraccept("담당교사 확인 대기중");
                    }

                    if (attendance.isManageraccept()) {
                        attendanceResponseDto.setManageraccept("행정실 확인 완료");
                    } else {
                        attendanceResponseDto.setManageraccept("행정실 확인 대기중");
                    }

                    return attendanceResponseDto;
                }).toList();

        attendanceResponsePageDto.setList(list);

        return attendanceResponsePageDto;
    }
}
