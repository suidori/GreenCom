package ex06;

public class Ex02 {
	public static void main(String[] args) {
		for(int i = 2; i<10; i++) {
			for(int j = 1; j<10; j++) {
				System.out.print("[" + i+" * "+j+" = "+i*j+ "] ");
			}
			System.out.print("\n");
		}
	}
}
