package attendance.management.question;

import attendance.management.utility.PageUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("save")
    public ResponseEntity<Question> save(@RequestHeader("Authorization") String token, @Valid @RequestBody QuestionReqDto questionReqDto) {
        Question question = questionService.save(token, questionReqDto);
        return ResponseEntity.ok(question);
    }

    @GetMapping("view/{idx}")
    public ResponseEntity<QuestionResponseDto> findOne(@PathVariable(name = "idx") long idx) {
        QuestionResponseDto questionResponseDto = questionService.viewPage(idx);
        return ResponseEntity.ok(questionResponseDto);
    }

    @GetMapping("/student")
    public ResponseEntity<QuestionResponsePageDto> studentFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        QuestionResponsePageDto questionResponsePageDto = questionService.studentPage(PageUtil.getPageable(pageNum, size), token);
        return ResponseEntity.ok(questionResponsePageDto);
    }

    @GetMapping("/teacher")
    public ResponseEntity<QuestionResponsePageDto> teacherFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        QuestionResponsePageDto questionResponsePageDto = questionService.teacherPage(PageUtil.getPageable(pageNum, size), token);
        return ResponseEntity.ok(questionResponsePageDto);
    }

    @GetMapping("/manager")
    public ResponseEntity<QuestionResponsePageDto> managerFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        QuestionResponsePageDto questionResponsePageDto = questionService.managerPage(PageUtil.getPageable(pageNum, size));
        return ResponseEntity.ok(questionResponsePageDto);
    }

}
