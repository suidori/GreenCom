/*
 3. 프로그램 사용자로부터 10진수 형태로 정수를 하나 입력받은 다음, 이를 2진수로 변환해서 출력하는 프로그램을 작성해 보자.
 */

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();
        int b = 1;
        String bi = "";
        String bi2= "";
        while (dec != 0) {
            bi = bi + dec%2;
            dec /= 2;
        }
        char[] chars = bi.toCharArray();
        for (int i = bi.length()-1; i >=0 ; i--) {
            bi2 = bi2 + chars[i];
        }
        System.out.println(bi2);
    }

}