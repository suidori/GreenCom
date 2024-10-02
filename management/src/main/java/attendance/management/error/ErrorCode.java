package attendance.management.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ErrorCode {

    DUPLICATE_USERID(HttpStatus.BAD_REQUEST, "아이디 중복입니다."),
    DUPLICATE_USERMAIL(HttpStatus.BAD_REQUEST, "email 중복입니다."),

    ;

    private HttpStatus httpStatus;
    private String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
