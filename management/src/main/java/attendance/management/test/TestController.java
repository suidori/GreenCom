package attendance.management.test;

import attendance.management.sign.LoginUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/roles")
    public String getUserRoles() {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            // 사용자 정보 가져오기
            LoginUserDetails userDetails = (LoginUserDetails) authentication.getPrincipal();
            String userid = userDetails.getUsername();

            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // 추가적인 로직 수행
            StringBuilder roles = new StringBuilder("User Roles: ");
            for (GrantedAuthority authority : authorities) {
                roles.append(authority.getAuthority()).append(" ");
            }
            return "Userid: " + userid + " " + roles.toString();
        } else return "";



    }

}
