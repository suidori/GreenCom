package attendance.management.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponsePageDto {

    @JsonIgnore
    private List<Question> content;

    private List<QuestionResponseDto> list;
    private int totalElements;
    private int totalPages;
    private int size;
}
