package attendance.management.answer;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.jwt.JWTManager;
import attendance.management.question.Question;
import attendance.management.question.QuestionRepository;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
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
    private final JWTManager jwtManager;
    private final UserRepository userRepository;

    public Answer save(AnswerReqDto answerReqDto, String token) {
        long userIdx = jwtManager.extractUserIdxFromToken(token);

        User user = userRepository
                .findById(userIdx)
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));
        Question question = questionRepository
                .findById(answerReqDto.getIdx())
                .orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        Answer answer = Answer.builder()
                .body(answerReqDto.getBody())
                .wdate(LocalDateTime.now())
                .user(user)
                .question(question)
                .build();

        answerRepository.save(answer);
        return answer;
    }

    public AnswerResponseDto view(long idx) {
        Answer answer = answerRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        AnswerResponseDto answerResponseDto = modelMapper.map(answer, AnswerResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
        answerResponseDto.setWdate(dateTimeFormatter.format(answer.getWdate()));

        answerResponseDto.setUser((answer.getUser() != null) ? answer.getUser().getName() : "탈퇴한 회원");

        return answerResponseDto;
    }
}
