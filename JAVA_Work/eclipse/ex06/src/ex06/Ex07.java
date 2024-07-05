package ex06;

public class Ex07 {

	public static void main(String[] args) {
		System.out.println(doA(3));
		System.out.println(doB("문자열"));
		
		
	}

	public static int doA(int num) {
		return num*num;
	}
	
	public static String doB(String str) {
		return str + str ;
	}
	
}
