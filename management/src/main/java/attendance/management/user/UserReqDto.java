package attendance.management.user;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserReqDto {

    @NotEmpty
    @Schema(description = "아이디", example = "userid")
    String userid;

    @NotEmpty
    @Schema(description = "비밀번호", example = "password")
    String password;

    @NotEmpty
    @Schema(description = "전화번호", example = "010-1234-5678")
    String phoneNumber;

    @NotEmpty
    @Schema(description = "이메일", example = "aaa@example.com")
    String email;

    @NotEmpty
    @Schema(description = "권한", example = "학생")
    String level;
}
