package attendance.management.answer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("answer")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("save")
    public ResponseEntity<Answer> save(@Valid @RequestBody AnswerReqDto answerReqDto) {
        Answer answer = answerService.save(answerReqDto);
        return ResponseEntity.status(200).body(answer);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<AnswerResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        AnswerResponseDto answerResponseDto = answerService.view(idx);
        return ResponseEntity.ok(answerResponseDto);
    }


}
