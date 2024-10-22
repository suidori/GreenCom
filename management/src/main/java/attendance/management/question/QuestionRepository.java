package attendance.management.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findByUser_Idx(Long useridx, Pageable pageable);
    Page<Question> findByLecture_Idx(Long lectureidx, Pageable pageable);
}
