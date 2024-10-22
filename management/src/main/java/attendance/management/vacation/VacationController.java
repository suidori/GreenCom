package attendance.management.vacation;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.question.QuestionReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("vacation")
@Slf4j
public class VacationController {

    private final VacationService vacationService;

    @PostMapping("request")
    public ResponseEntity<VacationResponseDto> request(
            @RequestBody VacationReqDto vacationReqDto,
            @RequestHeader("Authorization") String token
    ) {
        VacationResponseDto vacationResponseDto = vacationService.request(vacationReqDto, token);
        return ResponseEntity.status(200).body(vacationResponseDto);
    }

    @GetMapping("/student")
    public ResponseEntity<VacationResponsePageDto> studentFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        VacationResponsePageDto vacationResponsePageDto = vacationService.studentPage(pageable, token);
        return ResponseEntity.ok(vacationResponsePageDto);
    }

    @GetMapping("/teacher")
    public ResponseEntity<VacationResponsePageDto> teacherFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        VacationResponsePageDto vacationResponsePageDto = vacationService.teacherPage(pageable, token);
        return ResponseEntity.ok(vacationResponsePageDto);
    }

    @GetMapping("/manager")
    public ResponseEntity<VacationResponsePageDto> managerFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size){
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        VacationResponsePageDto vacationResponsePageDto = vacationService.managerPage(pageable);
        return ResponseEntity.ok(vacationResponsePageDto);
    }


    @PostMapping("/accept/{idx}")
    public ResponseEntity<String> accept(@PathVariable long idx) throws Exception {
        vacationService.accept(idx);
        return ResponseEntity.status(200).body(vacationService.newHWP(idx));
    }

    @GetMapping("/download/hwp/{idx}")
    public ResponseEntity<Resource> downloadHwpFile(@PathVariable long idx) throws IOException {

        VacationFileDto vacationFileDto = vacationService.download(idx);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/hwp"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(vacationFileDto.getFileName(), StandardCharsets.UTF_8) + "\"")
                .body(vacationFileDto.getResource());
    }


}
