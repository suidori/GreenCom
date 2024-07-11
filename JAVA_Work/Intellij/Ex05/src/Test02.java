/*
2.
길이가 10인 배열을 선언하고 총 10개의 정수를 입력받는다.
 단, 입력받은 숫자가 홀수이면 배열의 앞에서부터 채워나가고,
 짝수이면 뒤에서부터 채워나가는 형식을 취하기로 하자.
 따라서 사용자가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]을 입력했다면,
 배열에는 [1, 3, 5, 7, 9, 10, 8, 6, 4, 2]의 순으로 저장이 되어야 한다.
 */

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        System.out.println("정수 10개를 입력하세요. 각 정수는 공백으로 구분됩니다.");
        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        String result = odd(num) + "" + even(num);
        System.out.println(result);
    }

    public static String odd(int[] num) {
        String odd = "";
        for (int i = 0; i < 10; i++) {
            if (num[i] % 2 != 0) {
                odd = odd +  " " + num[i];
            }
        }
        return odd;
    }

    public static String even(int[] num) {
        String even = "";
        for (int i = 9; i >= 0; i--) {
            if (num[i] % 2 == 0) {
                even = even + " " + num[i];
            }
        }
        return even;
    }

}
