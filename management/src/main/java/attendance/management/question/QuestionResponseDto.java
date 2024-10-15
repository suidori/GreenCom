package attendance.management.question;

import lombok.Data;

@Data
public class QuestionResponseDto {

    private Long idx;
    private String title;
    private String body;
    private String wdate;
    private String user;
    private String response;

}
