package attendance.management.vacation;

import attendance.management.lecture.Lecture;
import attendance.management.user.User;
import lombok.Data;

@Data
public class VacationReqDto {

    private User user;

    private Lecture lecture;

    private String personalNum;

    private String reason;

    private String date;

    private String phonecall;
}
