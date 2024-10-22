package attendance.management.userandlecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attendance.management.user.User;
import java.util.Optional;

@Repository
public interface UserAndLectureRepository extends JpaRepository<UserAndLecture, Long> {
    Optional<UserAndLecture> findByUser(User user);
    Optional<UserAndLecture> findByUser_Idx(Long userIdx);
}
