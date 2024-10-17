package attendance.management.attendance;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceResponseDto {

    private Long idx;
    private String type;
    private String reason;
    private LocalDate adate;
    private String user;
    private String lecture;
    private String teacheraccept;
    private String manageraccept;

}
