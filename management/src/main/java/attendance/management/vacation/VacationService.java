package attendance.management.vacation;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.lecture.Lecture;
import attendance.management.lecture.LectureRepository;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationService {

    private final VacationRepository vacationRepository;
    private final ModelMapper modelMapper;
    private final VacationFileEditor vacationFileEditor;
    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    public Vacation request(VacationReqDto vacationReqDto) {
        Optional<User> user = userRepository.findByName(vacationReqDto.getUser().getName());
        user.ifPresentOrElse(vacationReqDto::setUser, ()-> new BizException(ErrorCode.USER_NOT_FOUND));
        Optional<Lecture> lecture = lectureRepository.findByTitle(vacationReqDto.getLecture().getTitle());
        lecture.ifPresentOrElse(vacationReqDto::setLecture, ()-> new BizException(ErrorCode.LECTURE_NOT_FOUND));

        Vacation vacation = modelMapper.map(vacationReqDto, Vacation.class);
        vacation.setWdate(LocalDate.now());
        vacation.setAccept(false);
        vacationRepository.save(vacation);
        return vacation;
    }

    public Vacation accept(long idx) {
        Optional<Vacation> vacation = vacationRepository.findById(idx);
        vacation.ifPresentOrElse(vacation1 -> {
                    vacation1.setAccept(true);
                    vacationRepository.save(vacation1);
                },
                () -> {
            new BizException(ErrorCode.REQUEST_NOT_FOUND);
                });
        return vacation.get();
    }

    public void download(long idx) throws Exception {
        vacationFileEditor.newHWP(idx);
    }

}
