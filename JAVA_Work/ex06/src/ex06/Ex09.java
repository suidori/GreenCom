package ex06;

import java.util.Scanner;

public class Ex09 {
	
	public static void doA() {
		System.out.println("doA 함수");
	}
	
	public static void doB() {
		System.out.println("doB 함수");
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int select = scan.nextInt();
		
		if(select ==1) {
			doA();
		}
		else if(select==2) {
			doB();
		}
		else {
			System.out.println("뭘 넣은 거야?");
		}
		
		
		
	}
}
