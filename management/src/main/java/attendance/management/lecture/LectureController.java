package attendance.management.lecture;

import attendance.management.userandlecture.UserAndLecture;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RequestMapping("lecture")
public class LectureController {

    private final LectureService lectureService;

    @PostMapping("save")
    public ResponseEntity<Lecture> save(@Valid @RequestBody LectureReqDto lectureReqDto){
        Lecture lecture = lectureService.save(lectureReqDto);
        return ResponseEntity.ok(lecture);
    }

    @PostMapping("join")
    public ResponseEntity<UserAndLecture> join(@RequestBody LectureReqDto lectureReqDto,
                                               @RequestHeader("Authorization") String token){
        UserAndLecture lecture = lectureService.join(lectureReqDto, token);
        return ResponseEntity.ok(lecture);
    }

}
