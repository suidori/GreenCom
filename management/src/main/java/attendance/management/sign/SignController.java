package attendance.management.sign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SignController {

    private final SignInService signInService;

    @PostMapping("/signin")
    public String join(@RequestBody JoinDto joinDto){
        signInService.join(joinDto);
        return "success";
    }
}
