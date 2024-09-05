package NYH.ex01.component;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class AA {

    public void insert(String name, int age){
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
    }

}
