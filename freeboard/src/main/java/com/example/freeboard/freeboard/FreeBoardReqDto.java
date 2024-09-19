package com.example.freeboard.freeboard;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class FreeBoardReqDto {

    @Length(max = 32)
    @NotEmpty
    @Schema(description = "글쓴이", example = "ㅇㅇ", defaultValue = "ㅇㅇ")
    private String f_nickname;

    @Length(min = 4, max = 16)
    @NotEmpty
    @Schema(description = "비밀번호", example = "1234", hidden = true)
    private String f_password;

    @Length(max = 80)
    @NotEmpty
    @Schema(description = "제목", example = "제목")
    private String f_title;

    @NotEmpty
    @Schema(description = "내용", example = "내용")
    private String f_body;

}
