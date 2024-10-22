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
import java.time.format.DateTimeFormatter;
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
                        throw new BizException(ErrorCode.ALREADY_RESPONDED);
                    } else {
                        question1.setResponse(true);
                    }
                }
                ),
                () -> {throw new BizException(ErrorCode.NOT_FOUND);}
        );

        answerRepository.save(answer);
        return answer;
    }

    public AnswerResponseDto view(long idx) {
        Answer answer = answerRepository.findById(idx).orElseThrow(()->new BizException(ErrorCode.NOT_FOUND));

        AnswerResponseDto answerResponseDto = modelMapper.map(answer, AnswerResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
        answerResponseDto.setWdate(dateTimeFormatter.format(answer.getWdate()));

        answerResponseDto.setUser((answer.getUser() != null) ? answer.getUser().getName() : "탈퇴한 회원");

        return answerResponseDto;
    }
}
