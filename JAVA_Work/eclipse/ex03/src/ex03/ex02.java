package ex03;

import java.util.Scanner;

public class ex02 {

	public static void main(String[] args) {
		
		//숫자를 입력받아 두 수의 합을 구하시오
		
		int a;
		int b;
		
		// 무언가를 입력받아서 사용할 때 쓰는 문법
		Scanner scan = new Scanner(System. in);
		
		System.out.println("숫자 입력");
		a = scan.nextInt();
		System.out.println("a = "+a);
		b = scan.nextInt();
		System.out.println("b = "+b);
		scan.close();
	}
}
