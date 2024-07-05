package ex04;

public class ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		boolean result = a % b == 0 || (a += 10) > 0;

		System.out.println(result);
		System.out.println(a);
	}
}
