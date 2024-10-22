package attendance.management.vacation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    Page<Vacation> findByUser_Idx(Long userIdx, Pageable pageable);
    Page<Vacation> findByLecture_Idx(Long lectureIdx, Pageable pageable);
}
