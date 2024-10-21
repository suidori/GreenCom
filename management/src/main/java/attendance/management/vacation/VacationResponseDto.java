package attendance.management.vacation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacationResponseDto {
    private Long idx;
    private String user;
    private String lecture;
    private String personalNum;
    private String reason;
    private String date;
    private String wdate;
    private String phonecall;
}
