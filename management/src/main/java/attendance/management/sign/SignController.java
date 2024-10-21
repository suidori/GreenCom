package attendance.management.sign;

import attendance.management.jwt.JWTManager;
import attendance.management.user.User;
import attendance.management.user.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("sign")
public class SignController {

    private final SignInService signInService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTManager jwtManager;

    @PostMapping("/signin")
    public String join(@RequestBody JoinDto joinDto){
        signInService.join(joinDto);
        return "success";
    }

    @GetMapping("/login")
    public ResponseEntity<String> redirectWithPost(
            @RequestParam("userid") String userid,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {

        User user = userRepository.findByUserid(userid).orElseThrow(
                () -> new UsernameNotFoundException(userid)
        );

        boolean isMatch = passwordEncoder.matches(password, user.getPassword());
        if(isMatch){
            String jwt = jwtManager.createJWT(user.getUserid(), user.getRole());
            return ResponseEntity.ok(jwt);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디와 패스워드를 확인하세요");
        }
    }

}
