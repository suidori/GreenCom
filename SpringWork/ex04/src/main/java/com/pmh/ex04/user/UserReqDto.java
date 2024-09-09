package com.pmh.ex04.user;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserReqDto {

    private Long idx;

    private String name;
    private int age;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    private LocalDateTime wdate;
}
