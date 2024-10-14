package attendance.management.user;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserReqDto {

    @NotEmpty
    @Schema(description = "아이디", example = "userid")
    private String userid;

    @NotEmpty
    @Schema(description = "비밀번호", example = "password")
    private String password;

    @NotEmpty
    @Schema(description = "이름", example = "홍길동")
    private String name;

    @NotEmpty
    @Schema(description = "전화번호", example = "010-1234-5678")
    private String phoneNumber;

    @Schema(description = "이메일", example = "aaa@example.com")
    private String email;

    @NotEmpty
    @Schema(description = "권한", example = "student")
    private String role;

    @Schema(description = "강좌", example = "505호 자바 MSA")
    private String lecture;
}
