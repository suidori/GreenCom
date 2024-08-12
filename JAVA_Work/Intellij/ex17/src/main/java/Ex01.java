import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex01 {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

            PreparedStatement pstmt = conn.prepareStatement("create table test (aa varchar(255), bb varchar(255))");

            pstmt.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
