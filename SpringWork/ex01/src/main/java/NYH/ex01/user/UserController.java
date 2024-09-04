package NYH.ex01.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@RestController
@CrossOrigin
public class UserController {

    @GetMapping("member/insert")
    public String aa(@RequestParam(name = "name", defaultValue = "이름") String name,
                     @RequestParam(name = "age", defaultValue = "30") int age) {
        try (Connection connection
                     = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/NYH", "root", "0715")) {
            PreparedStatement pstmt
                    = connection.prepareStatement("""
                    INSERT INTO Member
                        (name, age)
                    VALUES
                        (?,?)
                    """);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "memberTable 저장했습니다.";
    }

    @GetMapping("bb")
    public String bb() {
        return "bb";
    }

}