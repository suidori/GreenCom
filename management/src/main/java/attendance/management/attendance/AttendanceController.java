package attendance.management.attendance;

import attendance.management.user.User;
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

    private final AttendanceRepository attendanceRepository;
    private final AttendanceService attendanceService;

    @PostMapping("/unlogin")
    public ResponseEntity<Attendance> unlogged(@RequestBody AttendanceReqDto attendanceReqDto) {
        Attendance attendance = attendanceService.unlogged(attendanceReqDto);
        return ResponseEntity.status(200).body(attendance);
    }

    @GetMapping("/student")
    public ResponseEntity<AttendanceResponsePageDto> studentFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestBody AttendanceReqDto attendanceReqDto
            ){
        Sort sort = Sort.by(Sort.Direction.DESC, "idx");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.studentPage(pageable, attendanceReqDto);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

}
