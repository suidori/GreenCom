package attendance.management.vacation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("vacation")
@Slf4j
public class VacationController {

    private final VacationService vacationService;

    @PostMapping("request")
    public ResponseEntity<Vacation> request(@RequestBody VacationReqDto vacationReqDto){
        Vacation vacation = vacationService.request(vacationReqDto);
        return ResponseEntity.status(200).body(vacation);
    }

    @PostMapping("/accept/{idx}")
    public ResponseEntity<Vacation> accept(@PathVariable long idx) throws Exception {
        Vacation vacation = vacationService.accept(idx);
        vacationService.download(idx);
        return ResponseEntity.status(200).body(vacation);
    }

}
