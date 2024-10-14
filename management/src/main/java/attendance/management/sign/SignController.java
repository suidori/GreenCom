package attendance.management.sign;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final SignInService signInService;

    @PostMapping("/signIn")
    public String join(@RequestBody JoinDto joinDto){
        signInService.join(joinDto);
        return "success";
    }
}
