package attendance.management.vacation;

import lombok.Data;

@Data
public class VacationReqDto {

    private String personalNum;

    private String reason;

    private String startdate;

    private String enddate;

    private String phonecall;
}
