/*
1. 길이가 10인 배열을 선언하고 총 10개의 정수를 입력받아서,
홀수와 짝수를 구분 지어 출력하는 프로그램을 작성해 보자.
일단 홀수부터 출력하고 나서 짝수를 출력하도록 하자.
단, 10개의 정수는 main 함수 내에서 입력받도록 하고,
배열 내에 존재하는 홀수만 출력하는 함수와 배열 내에 존재하는 짝수만 출력하는 함수를 각각 정의해서
 이 두 함수를 호출하는 방식으로 프로그램을 완성하자.
 */

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        System.out.println("정수 10개를 입력하세요. 각 정수는 공백으로 구분됩니다.");
        for (int i = 0; i < 10; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println("입력받은 숫자 = ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("[ %d ]", num[i]);
        }
        System.out.println();
        odd(num);
        even(num);

    }

    public static void odd(int[] num) {
        String odd = "홀수 = [";
        for (int i = 0; i < 10; i++) {
            if (num[i] % 2 != 0) {
                odd = odd + " " + num[i];
            }
        }
        odd = odd + " ] ";
        System.out.println(odd);
    }
    public static void even(int[] num) {
        String even = "짝수 = [";
        for (int i = 0; i < 10; i++) {
            if (num[i] % 2 == 0) {
                even = even + " " + num[i];
            }
        }
        even = even + " ] ";
        System.out.println(even);
    }

}