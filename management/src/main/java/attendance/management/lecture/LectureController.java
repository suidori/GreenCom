package attendance.management.lecture;

import attendance.management.user.User;
import attendance.management.user.UserReqDto;
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

    private final LectureRepository lectureRepository;
    private final LectureService lectureService;

    @PostMapping("save")
    public ResponseEntity<Lecture> save(@Valid @RequestBody LectureReqDto lectureReqDto){
        Lecture lecture = lectureService.save(lectureReqDto);
        return ResponseEntity.status(200).body(lecture);
    }

    @PostMapping("join")
    public ResponseEntity<UserAndLecture> join(@RequestBody LectureJoinReqDto lectureJoinReqDto){
        UserAndLecture lecture = lectureService.join(lectureJoinReqDto);
        return ResponseEntity.status(200).body(lecture);
    }

}
