package attendance.management.attendance;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.jwt.JWTManager;
import attendance.management.user.UserRepository;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserAndLectureRepository userAndLectureRepository;
    private final JWTManager jwtManager;

    public Attendance unlogged(AttendanceReqDto attendanceReqDto) {

        Attendance attendance = modelMapper.map(attendanceReqDto, Attendance.class);

        attendance.setUser
                (userRepository
                        .findByNameAndPhoneNumber(attendanceReqDto.getUser().getName(), attendanceReqDto.getUser().getPhoneNumber())
                        .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND)));

        attendance.setLecture(
                userAndLectureRepository
                        .findByUser_IdxAndState(attendance.getUser().getIdx(), 1)
                        .orElseThrow(() -> new BizException(ErrorCode.LECTURE_NOT_FOUND))
                        .getLecture()
        );

        attendance.setTeacheraccept(false);
        attendance.setManageraccept(false);

        attendanceRepository.save(attendance);

        return attendance;

    }

    public AttendanceResponsePageDto studentPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        Page<Attendance> page = attendanceRepository.findByUser_Idx(userIdx, pageable);

        return mapToAttendanceResponsePageDto(page);
    }

    public AttendanceResponsePageDto teacherPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);
        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser_Idx(userIdx);

        long lectureIdx = userAndLecture.orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND)).getLecture().getIdx();

        Page<Attendance> page = attendanceRepository.findByLecture_Idx(lectureIdx, pageable);

        return mapToAttendanceResponsePageDto(page);
    }


    public AttendanceResponsePageDto managerPage(Pageable pageable) {
        Page<Attendance> page = attendanceRepository.findAll(pageable);

        return mapToAttendanceResponsePageDto(page);
    }

    private AttendanceResponsePageDto mapToAttendanceResponsePageDto(Page<Attendance> page) {

        List<AttendanceResponseDto> filteredList = page
                .getContent()
                .stream()
                .map(attendance -> {
                    AttendanceResponseDto attendanceResponseDto = modelMapper.map(attendance, AttendanceResponseDto.class);
                    attendanceResponseDto.setUser((attendance.getUser() != null) ? attendance.getUser().getName() : "탈퇴한 회원");
                    attendanceResponseDto.setLecture((attendance.getLecture() != null) ? attendance.getLecture().getTitle() : "존재하지 않는 강좌");
                    attendanceResponseDto.setTeacheraccept(attendance.isTeacheraccept() ? "담당교사 확인 완료" : "담당교사 확인 대기중");
                    attendanceResponseDto.setManageraccept(attendance.isManageraccept() ? "행정실 확인 완료" : "행정실 확인 대기중");
                    return attendanceResponseDto;
                })
                .collect(Collectors.toList());

        AttendanceResponsePageDto attendanceResponsePageDto = modelMapper.map(page, AttendanceResponsePageDto.class);
        attendanceResponsePageDto.setList(filteredList);
        attendanceResponsePageDto.setTotalElements(page.getTotalElements());

        return attendanceResponsePageDto;

    }

}
