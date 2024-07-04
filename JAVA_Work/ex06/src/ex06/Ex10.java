package ex06;

import java.util.Scanner;

public class Ex10 {
/*
 * 1. 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오
 * 2. 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+4+...+10)의 결과를 계산하시오
 * 3. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을때, 몇까지 더해야 총합이 100이상이 되는지 구하시오
 * 4. for문을 while문으로 변경하시오
 */
	
	public static void test1() {
		int result = 0;
		for(int num = 1; num<=20; num++) { //num가 1~20까지 반복한다
			if(num%2!=0&&num%3!=0) { //num를 2로 나눴을때 나머지가 0이 아닐때 && num을 3으로 나눴을때 나머지가 0이 아닐때
				result += num; //결과값에 num을 더한다
			}
			//if가 성립 안 하면 아무것도 하지 않는다.
		}//num이 20이 넘어가면 for문이 끝난다.
		
		System.out.println(result); //출력
	}
	
	public static void test2() {
		int result = 0;
		for (int i = 1; i<=10; i++) {
			for (int j = 1; j<=i; j++) {
				result+=j;
			}
		}
		System.out.println(result);
	}
	
	public static void test3() {
		int result = 0;
		int sum = 0;
		for (int i = 0; sum<100; i++) {
			if(i%2==0) {
				sum -= i;
			}
			else {
				sum +=i;
			}
			result = i;
		}
			System.out.println(result);
	}
	
	public static void test4() {
		int i = 0;
		while(i<=10) {
			int j = 0;
			while(j < i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 번 정답을 호출하겠습니까?");
		int select = sc.nextInt();
		
		switch (select) {
		case 1: {
			test1();
			break;
		}
		case 2:{
			test2();
			break;
		}
		case 3:{
			test3();
			break;
		}
		case 4:{
			test4();
			break;
		}
		default:
			System.out.println("1에서 4까지의 정수를 넣어주세요.");
			break;
		}
		
		System.out.println("프로그램 종료");
		sc.close();
	}
	
}
