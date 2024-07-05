package ex03;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("최소공배수 구하기");
		System.out.println("첫 번째 숫자를 입력하세요");
		int a = sc.nextInt();
		System.out.println("첫 번째 숫자 = " + a);
		System.out.println("두 번째 숫자를 입력하세요");
		int b = sc.nextInt();
		System.out.println("두 번째 숫자 = " + b);

		int result = 1;
		while ((result % a != 0) || (result % b != 0)) {
			result++;
		}
		System.out.println("최소공배수는 " + result + "입니다.");
	}
}