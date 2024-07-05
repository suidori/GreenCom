package ex04;

import java.util.Scanner;

public class ex06 {
	public static void main(String[] args) {
//		숫자를 입력받아
//		10 미만이면 10 미만 출력
//		10 이상이고 20 이하이면 10이상 20이하 출력
//		20초과이면 20초과 출력

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자 입력");
		double num = sc.nextDouble();

		if (num < 10) {
			System.out.println("10 미만");
		} else if (num <= 20) {
			System.out.println("10 이상 20 이하");
		} else if (num > 20) {
			System.out.println("20 초과");
		}
		sc.close();
	}
}
