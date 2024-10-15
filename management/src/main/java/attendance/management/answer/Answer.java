package attendance.management.answer;

import attendance.management.question.Question;
import attendance.management.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String body;

    private LocalDateTime wdate;

    @ManyToOne
    @JoinColumn(name = "useridx")
    private User user;

    @OneToOne
    @JoinColumn(name = "qidx")
    private Question question;

}