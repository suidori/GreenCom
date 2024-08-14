package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DBRepository {

    public void insert(){
        try{
            Scanner sc = new Scanner(System.in);

            System.out.println("이름 입력");
            String name = sc.nextLine();
            System.out.println("나이 입력");
            int age = sc.nextInt();


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =
                    DriverManager
                            .getConnection(
                                    "jdbc:mysql://localhost:3306/NYH",
                                    "root",
                                    "0715");
            System.out.println("연결 성공");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO aa (name, age) VALUES (?, ?);");
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void select(){

    }

    public void update(){

    }

    public void delete(){

    }

}
