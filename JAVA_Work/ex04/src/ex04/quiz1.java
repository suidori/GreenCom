package ex04;

import java.util.Scanner;

public class quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int temp = n;
		int stack1 = 0;

		while (temp != 0) { // temp가 0이 될 때까지

			if ((temp % 2) != 0) { // temp가 홀수라면(1의 자리가 1이라면)
				stack1++; // 1스택 증가
			}
			temp = temp >> 1; // 비트 우측으로 이동
		}

		int num2 = n + 1;
		int stack2 = 0;
		temp = num2;
		while (stack1 != stack2) {
			stack2 = 0;
			while (temp != 0) {

				if ((temp % 2) != 0) {
					stack2++;

				}
				temp = temp >> 1;
			}
			temp = ++num2;
		}
		sc.close();
	}
	
}
