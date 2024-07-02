package ex04;

public class test4 {
	public static void main(String[] args) {
		int F = 100;
		float C = (float) (F - 32)*100/18*10 ;
		int temp =(int)C;
		C=temp/100f;
		System.out.println("F = " + F);
		System.out.println("C = " + C);
	}
}
//화씨 섭씨 변환 (셋째 자리 버림)