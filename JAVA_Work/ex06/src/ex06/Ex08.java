package ex06;

import java.util.Scanner;

public class Ex08 {
	
	public static int doA(int num) {
		return num*num;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("제곱하고 싶은 값 입력: ");
			int input = scan.nextInt();
			System.out.println(doA(input));
			
			
		}
		
	}
}
