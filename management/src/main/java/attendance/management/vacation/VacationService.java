package attendance.management.vacation;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationService {

    private final VacationRepository vacationRepository;
    private final ModelMapper modelMapper;
    private final VacationFileEditor vacationFileEditor;
    private final UserAndLectureRepository userAndLectureRepository;

    public VacationResponseDto request(VacationReqDto vacationReqDto) {
        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser(vacationReqDto.getUser());
        userAndLecture.ifPresentOrElse(
                userAndLecture1 -> {
                    vacationReqDto.setLecture(userAndLecture1.getLecture());
                    vacationReqDto.setUser(userAndLecture1.getUser());
                },
                () -> {
                    throw new BizException(ErrorCode.USER_NOT_FOUND);
                }
        );

        Vacation vacation = modelMapper.map(vacationReqDto, Vacation.class);
        vacation.setWdate(LocalDate.now());
        vacation.setAccept(false);
        vacationRepository.save(vacation);

        VacationResponseDto vacationResponseDto = VacationResponseDto
                .builder()
                .idx(vacation.getIdx())
                .user(vacation.getUser().getName())
                .date(vacation.getDate())
                .wdate(vacation.getWdate().toString())
                .reason(vacation.getReason())
                .lecture(vacation.getLecture().getTitle())
                .personalNum(vacation.getPersonalNum())
                .phonecall(vacation.getPhonecall())
                .build();

        return vacationResponseDto;
    }

    public Vacation accept(long idx) {
        Optional<Vacation> vacation = vacationRepository.findById(idx);
        vacation.ifPresentOrElse(vacation1 -> {
                    vacation1.setAccept(true);
                    vacationRepository.save(vacation1);
                },
                () -> {
                    throw new BizException(ErrorCode.REQUEST_NOT_FOUND);
                });
        return vacation.get();
    }

    public String newHWP(long idx) throws Exception {
        return vacationFileEditor.newHWP(idx);
    }

    public Resource download(String fileName) throws IOException {
        Path filePath = Paths.get("request_hwp", fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new BizException(ErrorCode.FILE_NOT_FOUND);
        }

        return resource;
    }

}
