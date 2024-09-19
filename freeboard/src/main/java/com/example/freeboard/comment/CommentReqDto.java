package com.example.freeboard.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CommentReqDto {

    private int c_idx;
    private boolean c_avail = true;

    @NotNull
    private long fidx;

    @Length(max = 32)
    @NotEmpty
    @Schema(description = "글쓴이", example = "ㅇㅇ", defaultValue = "ㅇㅇ")
    private String c_nickname;

    @Length(max = 16)
    @NotEmpty
    @Schema(description = "비밀번호", example = "1234", hidden = true)
    private String c_password;

    @NotEmpty
    @Schema(description = "내용", example = "내용")
    private String c_body;

    private Integer c_response_index;

    private Comment responseComment;
}
