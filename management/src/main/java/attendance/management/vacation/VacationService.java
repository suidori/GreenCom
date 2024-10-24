package attendance.management.vacation;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.jwt.JWTManager;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationService {

    private final VacationRepository vacationRepository;
    private final ModelMapper modelMapper;
    private final VacationFileEditor vacationFileEditor;
    private final UserAndLectureRepository userAndLectureRepository;
    private final JWTManager jwtManager;


    public VacationResponseDto request(VacationReqDto vacationReqDto, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        Vacation vacation = modelMapper.map(vacationReqDto, Vacation.class);

        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser_IdxAndState(userIdx, 1);
        userAndLecture.orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND));
        vacation.setLecture(userAndLecture.get().getLecture());
        vacation.setUser(userAndLecture.get().getUser());
        vacation.setWdate(LocalDate.now());
        vacation.setStartdate(LocalDate.parse(vacationReqDto.getStartdate()));
        vacation.setEnddate(LocalDate.parse(vacationReqDto.getEnddate()));
        vacationRepository.save(vacation);

        VacationResponseDto vacationResponseDto = modelMapper.map(vacationReqDto, VacationResponseDto.class);
        vacationResponseDto.setIdx(vacation.getIdx());
        vacationResponseDto.setUser(vacation.getUser().getName());
        vacationResponseDto.setLecture(vacation.getLecture().getTitle());
        vacationResponseDto.setWdate(vacation.getWdate().toString());
        if (vacation.getAccept() == null) {
            vacationResponseDto.setAccept("대기중");
        } else {
            vacationResponseDto.setAccept(vacation.getAccept() ? "허가됨" : "반려됨");
        }
        return vacationResponseDto;
    }

    public VacationResponseDto viewPage(long idx) {
        Vacation vacation = vacationRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.REQUEST_NOT_FOUND));
        VacationResponseDto vacationResponseDto = modelMapper.map(vacation, VacationResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd");
        vacationResponseDto.setWdate(dateTimeFormatter.format(vacation.getWdate()));
        vacationResponseDto.setStartdate(dateTimeFormatter.format(vacation.getStartdate()));
        vacationResponseDto.setEnddate(dateTimeFormatter.format(vacation.getEnddate()));
        if (vacation.getAccept() == null) {
            vacationResponseDto.setAccept("대기중");
        } else {
            vacationResponseDto.setAccept(vacation.getAccept() ? "허가됨" : "반려됨");
        }
        vacationResponseDto.setUser(vacation.getUser().getName());
        vacationResponseDto.setLecture(vacation.getLecture().getTitle());

        return vacationResponseDto;
    }

    public void accept(long idx) {
        Vacation vacation = vacationRepository
                .findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.REQUEST_NOT_FOUND));
        vacation.setAccept(true);
        vacationRepository.save(vacation);
    }

    public void deny(long idx) {
        Vacation vacation = vacationRepository
                .findById(idx)
                .orElseThrow(() -> new BizException(ErrorCode.REQUEST_NOT_FOUND));
        vacation.setAccept(false);
        vacationRepository.save(vacation);
    }

    public String newHWP(long idx) throws Exception {
        return vacationFileEditor.newHWP(idx);
    }

    public VacationFileDto download(long idx) throws IOException {
        Optional<Vacation> vacation = vacationRepository.findById(idx);
        String fileName = vacation.orElseThrow(() -> new BizException(ErrorCode.FILE_NOT_FOUND)).getHwpfile();
        Path filePath = Paths.get("request_hwp", fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            throw new BizException(ErrorCode.FILE_NOT_FOUND);
        }

        return new VacationFileDto(resource, fileName);
    }

    public VacationResponsePageDto studentPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        Page<Vacation> page = vacationRepository.findByUser_Idx(userIdx, pageable);

        return mapToVacationResponsePageDto(page);
    }

    public VacationResponsePageDto managerPage(Pageable pageable) {

        Page<Vacation> page = vacationRepository.findAll(pageable);

        return mapToVacationResponsePageDto(page);
    }

    public VacationResponsePageDto teacherPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);
        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser_Idx(userIdx);
        long lectureIdx = userAndLecture.orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND)).getLecture().getIdx();

        Page<Vacation> page = vacationRepository.findByLecture_Idx(lectureIdx, pageable);

        return mapToVacationResponsePageDto(page);

    }

    private VacationResponsePageDto mapToVacationResponsePageDto(Page<Vacation> page) {
        List<VacationResponseDto> filteredList = page.getContent().stream()
                .map(vacation -> {
                    VacationResponseDto vacationResponseDto = modelMapper.map(vacation, VacationResponseDto.class);
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd");
                    vacationResponseDto.setWdate(dateTimeFormatter.format(vacation.getWdate()));
                    vacationResponseDto.setStartdate(dateTimeFormatter.format(vacation.getStartdate()));
                    vacationResponseDto.setEnddate(dateTimeFormatter.format(vacation.getEnddate()));
                    vacationResponseDto.setUser(vacation.getUser().getName());
                    vacationResponseDto.setLecture(vacation.getLecture().getTitle());
                    if (vacation.getAccept() == null) {
                        vacationResponseDto.setAccept("대기중");
                    } else {
                        vacationResponseDto.setAccept(vacation.getAccept() ? "허가됨" : "반려됨");
                    }
                    return vacationResponseDto;
                })
                .collect(Collectors.toList());

        VacationResponsePageDto vacationResponsePageDto = modelMapper.map(page, VacationResponsePageDto.class);
        vacationResponsePageDto.setList(filteredList);
        vacationResponsePageDto.setTotalElements(page.getTotalElements());

        return vacationResponsePageDto;
    }


}

