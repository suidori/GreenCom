package attendance.management.lecture;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.jwt.JWTManager;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
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
    private final JWTManager jwtManager;
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

    public UserAndLecture join(LectureReqDto lectureReqDto, String token) {
        Lecture lecture = lectureRepository
                .findByTitle(lectureReqDto.getTitle())
                .orElseThrow(() -> new BizException(ErrorCode.LECTURE_NOT_FOUND));

        if (!lecture.isEnable()) {
            throw new BizException(ErrorCode.LECTURE_NOT_ENABLE);
        }

        if(!lecture.getPassword().equals(lectureReqDto.getPassword())) {
            throw new BizException(ErrorCode.PASSWORD_MISMATCH);
        }

        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        User user = userRepository
                .findById(userIdx)
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND));

        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser_IdxAndState(userIdx,1);

        userAndLecture.ifPresent(
                userAndLecture1 -> userAndLecture1.setState(0)
        );

        UserAndLecture userAndLecture1 = UserAndLecture.builder()
                .user(user)
                .lecture(lecture)
                .state(1)
                .build();

        userAndLectureRepository.save(userAndLecture1);

        return userAndLecture1;
    }

}
