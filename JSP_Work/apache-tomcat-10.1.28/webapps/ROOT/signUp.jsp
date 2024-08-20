<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%
    //주소줄에 있는 email password
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    out.println("email = " + email);
    out.println("password = "+ password);

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=
            DriverManager
                .getConnection(
                    "jdbc:mysql://112.222.157.156:3307/NYH",
                    "root",
                    "0715");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?);");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
    }
    finally{

    }

    response.sendRedirect("login.jsp?aa=bb");

%>