package ex05;

public class ex06 {
	public static void main(String[] args) {
		int num = 0;
		while((num++)<100) {
			if (num%2 != 0) {
				continue;
			}
			System.out.println(num);
		}
	}
}
