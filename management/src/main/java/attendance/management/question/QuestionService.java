package attendance.management.question;

import attendance.management.error.BizException;
import attendance.management.error.ErrorCode;
import attendance.management.jwt.JWTManager;
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

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final UserAndLectureRepository userAndLectureRepository;
    private final JWTManager jwtManager;

    public Question save(String token, QuestionReqDto questionReqDto) {

        long userIdx = jwtManager.extractUserIdxFromToken(token);

        Question question = modelMapper.map(questionReqDto, Question.class);
        question.setWdate(LocalDateTime.now());
        question.setResponse(false);

        UserAndLecture userAndLecture = userAndLectureRepository
                .findByUser_IdxAndState(userIdx, 1)
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND));

        question.setUser(userAndLecture.getUser());
        question.setLecture(userAndLecture.getLecture());

        questionRepository.save(question);
        return question;
    }

    public QuestionResponsePageDto studentPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        Page<Question> page = questionRepository.findByUser_Idx(userIdx, pageable);

        return mapToQuestionResponsePageDto(page);
    }

    public QuestionResponsePageDto teacherPage(Pageable pageable, String token) {
        Long userIdx = jwtManager.extractUserIdxFromToken(token);

        long lectureIdx = userAndLectureRepository
                .findByUser_Idx(userIdx)
                .orElseThrow(() -> new BizException(ErrorCode.USER_NOT_FOUND))
                .getLecture()
                .getIdx();

        Page<Question> page = questionRepository.findByLecture_Idx(lectureIdx, pageable);

        return mapToQuestionResponsePageDto(page);
    }

    public QuestionResponsePageDto managerPage(Pageable pageable) {

        Page<Question> page = questionRepository.findAll(pageable);

        return mapToQuestionResponsePageDto(page);
    }

    public QuestionResponseDto viewPage(long idx) {
        Question question = questionRepository.findById(idx).orElseThrow(() -> new BizException(ErrorCode.NOT_FOUND));

        QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
        questionResponseDto.setWdate(dateTimeFormatter.format(question.getWdate()));

        questionResponseDto.setUser((question.getUser() != null) ? question.getUser().getName() : "탈퇴한 회원");
        questionResponseDto.setResponse(question.isResponse() ? "답변 완료" : "답변 대기중");

        return questionResponseDto;

    }

    private QuestionResponsePageDto mapToQuestionResponsePageDto(Page<Question> page) {

        List<QuestionResponseDto> list = page
                .getContent()
                .stream()
                .map(question -> {
                    QuestionResponseDto questionResponseDto = modelMapper.map(question, QuestionResponseDto.class);

                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm");
                    questionResponseDto.setWdate(dateTimeFormatter.format(question.getWdate()));

                    questionResponseDto.setUser((question.getUser() != null) ? question.getUser().getName() : "탈퇴한 회원");
                    questionResponseDto.setResponse(question.isResponse() ? "답변 완료" : "답변 대기중");
                    questionResponseDto.setLecture(question.getLecture().getTitle());

                    return questionResponseDto;
                }).toList();

        QuestionResponsePageDto questionResponsePageDto = modelMapper.map(page, QuestionResponsePageDto.class);
        questionResponsePageDto.setList(list);

        return questionResponsePageDto;
    }

}
