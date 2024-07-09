import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("최대공약수 구하기");

            System.out.println("첫 번째 숫자를 입력하세요");
            int a = sc.nextInt();
            System.out.println("첫 번째 숫자 = " + a);

            System.out.println("두 번째 숫자를 입력하세요");
            int b = sc.nextInt();
            System.out.println("두 번째 숫자 = " + b);

            int gcd = gcd(a, b);
            System.out.println("최대공약수는 " + gcd + "입니다.");
            sc.close();
        }
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = a;
                a = b;
                b = temp % b;
            }
            return a;
        }
}
