package attendance.management.question;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.userandlecture.UserAndLecture;
import attendance.management.userandlecture.UserAndLectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final UserAndLectureRepository userAndLectureRepository;

    public Question save(QuestionReqDto questionReqDto) {
        Question question = modelMapper.map(questionReqDto, Question.class);
        question.setWdate(LocalDateTime.now());
        question.setResponse(false);

        Optional<UserAndLecture> userAndLecture = userAndLectureRepository.findByUser(questionReqDto.getUser());
        userAndLecture.ifPresentOrElse(
                userAndLecture1 -> question.setLecture(userAndLecture1.getLecture()),
                ()->new BizException(ErrorCode.USER_NOT_FOUND)
        );

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

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
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

    public QuestionResponsePageDto studentPage(Pageable pageable, QuestionReqDto questionReqDto){
        Long userIdx = questionReqDto.getUser().getIdx();

        Page<Question> page = questionRepository.findByUser_Idx(userIdx, pageable);

        List<QuestionResponseDto> filteredList = page
                .getContent()
                .stream()
                .map(question -> {
                    QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
                    questionResponseDto.setWdate(dateTimeFormatter.format(question.getWdate()));
                    questionResponseDto.setResponse(question.isResponse() ? "답변 완료" : "답변 대기중");
                    questionResponseDto.setUser((question.getUser() != null) ? question.getUser().getName() : "탈퇴한 회원");
                    return questionResponseDto;
                })
                .collect(Collectors.toList());

        QuestionResponsePageDto questionResponsePageDto = modelMapper.map(page, QuestionResponsePageDto.class);
        questionResponsePageDto.setList(filteredList);
        questionResponsePageDto.setTotalElements(page.getTotalElements());

        return questionResponsePageDto;
    }

    public QuestionResponseDto viewPage(long idx) {
        Question question = questionRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
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
