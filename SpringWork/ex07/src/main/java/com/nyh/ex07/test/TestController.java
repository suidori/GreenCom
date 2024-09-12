package com.nyh.ex07.test;

import com.nyh.ex07.obj.AA;
import com.nyh.ex07.obj.BB;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final AA aa;
    private final BB bb;

    @GetMapping("aa")
    public String aa(){
        aa.doA();
        return "aaaaaa";
    }

    @PostMapping
    public String bb(){
        bb.doB();
        return "bbbb";
    }

}
