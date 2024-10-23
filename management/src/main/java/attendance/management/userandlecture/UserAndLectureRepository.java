package attendance.management.userandlecture;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attendance.management.user.User;
import java.util.Optional;

@Repository
public interface UserAndLectureRepository extends JpaRepository<UserAndLecture, Long> {
    Optional<UserAndLecture> findByUser(User user);
    Optional<UserAndLecture> findByUser_Idx(Long userIdx);
    Optional<UserAndLecture> findByUser_IdxAndState(Long userIdx, int state);
    Page<UserAndLecture> findByUser_Idx(Long userIdx, Pageable pageable);
}
