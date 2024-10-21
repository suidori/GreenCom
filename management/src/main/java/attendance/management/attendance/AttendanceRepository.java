package attendance.management.attendance;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Page<Attendance> findByUser_Idx(Long userId, Pageable pageable);
}
