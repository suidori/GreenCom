package attendance.management.question;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public Question save(QuestionReqDto questionReqDto) {
        Question question = modelMapper.map(questionReqDto, Question.class);
        question.setWdate(LocalDateTime.now());
        question.setResponse(false);

        questionRepository.save(question);

        return question;
    }

    public QuestionResponsePageDto questionPage(Pageable pageable) {
        Page<Question> page = questionRepository.findAll(pageable);

        QuestionResponsePageDto questionResponsePageDto = modelMapper.map(page, QuestionResponsePageDto.class);

        List<QuestionResponseDto> list = questionResponsePageDto
                .getContent()
                .stream()
                .map(question -> {
                    QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
                    questionResponseDto.setWdate(dateTimeFormatter.format(question.getWdate()));

                    if (question.getUser() != null) {
                        questionResponseDto.setUser(question.getUser().getName());
                    } else {
                        questionResponseDto.setUser("탈퇴한 회원");
                    }

                    if (question.isResponse()) {
                        questionResponseDto.setResponse("답변 완료");
                    } else {
                        questionResponseDto.setResponse("답변 대기중");
                    }
                    return questionResponseDto;
                }).toList();
        questionResponsePageDto.setList(list);

        return questionResponsePageDto;
    }

    public QuestionResponseDto viewPage(long idx) {
        Question question = questionRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm");
        questionResponseDto.setWdate(dateTimeFormatter.format(question.getWdate()));

        if (question.getUser() != null) {
            questionResponseDto.setUser(question.getUser().getName());
        } else {
            questionResponseDto.setUser("탈퇴한 회원");
        }

        if (question.isResponse()) {
            questionResponseDto.setResponse("답변 완료");
        } else {
            questionResponseDto.setResponse("답변 대기중");
        }

        return questionResponseDto;

    }

}