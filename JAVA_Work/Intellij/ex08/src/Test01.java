/*
Hello.java 문자열에서 파일명과 확장자를 분리시켜보자
 */

public class Test01 {
    public static void main(String[] args) {
        String str = "Hello.java";
        String[] output = str.split("\\.");
        System.out.println("파일명 " + output[0]);
        System.out.println("확장자 " + output[1]);
    }
}
