package attendance.management.answer;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.question.Question;
import attendance.management.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnswerService {

    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Answer save(AnswerReqDto answerReqDto) {
        Answer answer = modelMapper.map(answerReqDto, Answer.class);
        answer.setWdate((LocalDateTime.now()));
        Optional<Question> question = questionRepository.findById(answer.getQuestion().getIdx());

        question.ifPresentOrElse(
                (question1 -> {
                    if (question1.isResponse()) {
                        new BizException(ErrorCode.ALREADY_RESPONDED);
                    } else {
                        question1.setResponse(true);
                    }
                }
                ),
                () -> new BizException(ErrorCode.NOT_FOUND)
        );

        answerRepository.save(answer);
        return answer;
    }

}
