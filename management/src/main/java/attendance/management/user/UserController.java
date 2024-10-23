package attendance.management.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/roles")
    public String getUserRoles() {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 사용자가 가지고 있는 권한(Role) 목록 가져오기
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Role 목록을 문자열로 변환하여 출력
        StringBuilder roles = new StringBuilder("User Roles: ");
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority()).append(" ");
        }

        return roles.toString();
    }


}
