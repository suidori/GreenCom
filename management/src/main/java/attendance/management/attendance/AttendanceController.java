package attendance.management.attendance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("attendance")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class AttendanceController {

    private final AttendanceService attendanceService;

    

    @PostMapping("/unlogin")
    public ResponseEntity<Attendance> unlogged(@RequestBody AttendanceReqDto attendanceReqDto) {
        Attendance attendance = attendanceService.unlogged(attendanceReqDto);
        return ResponseEntity.status(200).body(attendance);
    }

    @GetMapping("/student")
    public ResponseEntity<AttendanceResponsePageDto> studentFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.studentPage(pageable, token);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

    @GetMapping("/teacher")
    public ResponseEntity<AttendanceResponsePageDto> teacherFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.teacherPage(pageable, token);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

    @GetMapping("/manager")
    public ResponseEntity<AttendanceResponsePageDto> managerFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.managerPage(pageable);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

}
