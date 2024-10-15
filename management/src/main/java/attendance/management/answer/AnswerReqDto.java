package attendance.management.answer;

import attendance.management.question.Question;
import attendance.management.user.User;
import lombok.Data;

@Data
public class AnswerReqDto {

    private String body;

    private User user;

    private Question question;
}
