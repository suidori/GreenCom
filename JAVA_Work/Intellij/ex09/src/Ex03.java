public class Ex03 {
    public static void main(String[] args) {
        String str0 = new String("new String"); //새로운 String 객체를 만듬
        String str1 = "new String"; //기존 java 문자열 풀을 사용함
        String str2 = "new String"; //기존 문자열 풀에서 검색함

        System.out.println(str0==str1);
        System.out.println(str1==str2);

        String str3 = new String("new String");
        String str4 = new String("new String");

        System.out.println(str3==str4);
    }
}