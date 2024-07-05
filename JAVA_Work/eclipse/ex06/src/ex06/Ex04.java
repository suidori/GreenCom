package ex06;

public class Ex04 {
	
	public static void aa(int dan) {
		System.out.println("구구단을 외자");
		
		for(int i = 1; i<10; i++) {
			System.out.print("[ " + dan + " * " + i + " = " + dan*i + " ] ");
		}
		System.out.print("\n");
	}
	
	public static void bb(int num1, int num2) {
		System.out.println("최소공배수를 구하자");
		int temp = 0;
		int calc = num1*num2;
		while(num2 != 0) {
			temp = num1;
			num1 = num2;
			num2 = temp%num1;
		}
		System.out.println("최소공배수 = " + calc/num1);
	}
	
	public static void main(String[] args) {
		aa(5);
		bb(3, 4);
		System.out.println("시스템 종료");
	}
}
