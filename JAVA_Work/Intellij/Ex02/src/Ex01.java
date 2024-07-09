//2의 n승을 구하는 함수를 재귀적으로 구현해 보자

import java.util.Scanner;

public class Ex01 {
    public static long square(int i, int n, long result){
        if( n == 0 ){
            return result;
        }
        else{
            result *= i;
            n--;
            result =  square(i , n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("i의 n승을 구하는 함수입니다. \n i 와 n 을 차례로 입력하세요.");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("밑수는 "+ i + "입니다.");
        int n = sc.nextInt();
        System.out.println("지수는 " + n + "입니다.");
        long result = 1;
        result = square(i, n, result);
        System.out.println(i + "의 " + n +"제곱은 " + result + "입니다.");

    }
}