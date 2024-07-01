package ex03;

import java.util.Scanner;

public class quiz01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		a *=100;
		int b=(int)a;
		System.out.println((double)b/100);
	}
}
