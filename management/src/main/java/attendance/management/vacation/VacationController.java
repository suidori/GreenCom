package attendance.management.vacation;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("vacation")
@Slf4j
public class VacationController {

    private final VacationService vacationService;

    @PostMapping("request")
    public ResponseEntity<VacationResponseDto> request(@RequestBody VacationReqDto vacationReqDto) {
        VacationResponseDto vacationResponseDto = vacationService.request(vacationReqDto);
        return ResponseEntity.status(200).body(vacationResponseDto);
    }

    @PostMapping("/accept/{idx}")
    public ResponseEntity<String> accept(@PathVariable long idx) throws Exception {
        vacationService.accept(idx);
        return ResponseEntity.status(200).body(vacationService.newHWP(idx));
    }

    @GetMapping("/download/hwp/{fileName}")
    public ResponseEntity<Resource> downloadHwpFile(@PathVariable String fileName) throws IOException {

        Resource resource = vacationService.download(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/hwp")) // HWP 파일에 적합한 MIME 타입 설정
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + URLEncoder.encode(fileName, StandardCharsets.UTF_8) + "\"")
                .body(resource);
    }


}
