package attendance.management.attendance;

import attendance.management.utility.PageUtil;
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
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.studentPage(PageUtil.getPageable(pageNum, size), token);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

    @GetMapping("/teacher")
    public ResponseEntity<AttendanceResponsePageDto> teacherFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.teacherPage(PageUtil.getPageable(pageNum, size), token);
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

    @GetMapping("/manager")
    public ResponseEntity<AttendanceResponsePageDto> managerFindAll(
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestHeader("Authorization") String token
    ) {
        AttendanceResponsePageDto attendanceResponsePageDto = attendanceService.managerPage(PageUtil.getPageable(pageNum, size));
        return ResponseEntity.ok(attendanceResponsePageDto);
    }

}
