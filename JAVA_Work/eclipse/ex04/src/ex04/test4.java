package ex04;

public class test4 {
	public static void main(String[] args) {
		int F = 100;
		float C = (float)(((int)((float)(F - 32)/18*10*100)))/100;
		System.out.println("F = " + F);
		System.out.println("C = " + C);
	}
}
//화씨 섭씨 변환 (셋째 자리 버림)