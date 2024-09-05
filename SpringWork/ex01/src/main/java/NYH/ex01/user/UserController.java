package NYH.ex01.user;

import NYH.ex01.component.AA;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final AA aa;

    @GetMapping("member/insert")
    public String aa(@RequestParam(name = "name", defaultValue = "이름") String name,
                     @RequestParam(name = "age", defaultValue = "30") int age) {
        aa.insert(name, age);
        return "memberTable 저장했습니다.";
    }

    @GetMapping("bb")
    public String bb() {
        return "bb";
    }

}