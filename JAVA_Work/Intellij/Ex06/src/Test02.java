/*
 2.숫자로 이루어진 문자열 이 있을 때 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
 만일 문자열이 12345면 1+2+3+4+5 결과인 15를 출력하여야 한다
         [Hint] String charAt(int i)
 */
public class Test02 {
    public static void main(String[] args) {
        String str = "12345";
                int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (int)(str.charAt(i))-48;
        }
        System.out.println(sum);
    }
}
