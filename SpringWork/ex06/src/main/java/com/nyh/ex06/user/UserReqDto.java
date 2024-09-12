package com.nyh.ex06.user;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class UserReqDto {

    private Long idx;

    @Length(min = 2, max = 100)
    private String name;

    @Min(0)@Max(130)
    private int age;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    private LocalDateTime wdate;
}