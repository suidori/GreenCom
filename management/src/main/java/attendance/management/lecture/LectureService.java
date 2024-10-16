package attendance.management.lecture;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
import attendance.management.user.UserReqDto;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import attendance.management.userandlecture.UserAndLectureReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LectureService {

    private final ModelMapper modelMapper;
    private final LectureRepository lectureRepository;
    private final UserAndLectureRepository userAndLectureRepository;
    private final UserRepository userRepository;

    public Lecture save(LectureReqDto lectureReqDto) {
        Lecture lecture = modelMapper.map(lectureReqDto, Lecture.class);

        LocalDate now = LocalDate.now();
        if (now.isBefore(lecture.getStartDate())) {
            lecture.setEnable(false);
        } else {
            lecture.setEnable(true);
        }
        if (now.isAfter(lecture.getEndDate())) {
            lecture.setEnable(false);
        }

        lecture = lectureRepository.save(lecture);

        return lecture;
    }

    public UserAndLecture join(LectureJoinReqDto lectureJoinReqDto) {
        UserAndLecture userAndLecture = new UserAndLecture();
        Optional<Lecture> lecture = lectureRepository.findByTitle(lectureJoinReqDto.getLectureReqDto().getTitle());
        lecture.ifPresentOrElse(
                lecture1 -> {
                    if (lecture1.getPassword().equals(lectureJoinReqDto.getLectureReqDto().getPassword())) {
                        userAndLecture.setLecture(lecture1);
                    } else {
                        new BizException(ErrorCode.PASSWORD_MISMATCH);
                    }
                },
                () -> new BizException(ErrorCode.LECTURE_NOT_FOUND)
        );
        Optional<User> user = userRepository.findByNameAndUserid(lectureJoinReqDto.getUserReqDto().getName(), lectureJoinReqDto.getUserReqDto().getUserid());
        user.ifPresentOrElse(
                userAndLecture::setUser,
                () -> new BizException(ErrorCode.USER_NOT_FOUND)
        );

        userAndLectureRepository.save(userAndLecture);

        return userAndLecture;
    }

}
