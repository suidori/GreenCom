//초를 입력받아 [시, 분, 초]의 형태로 출력하는 프로그램
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("초를 입력하면 시, 분, 초로 변환하는 프로그램입니다.");
        System.out.println("숫자를 입력하세요");
        long time = sc.nextLong();
        int hour = (int)(time/3600);
        int minute = (int)((time%3600)/60);
        int second = (int)((time%3600)%60);
        System.out.println("[ " + hour + "시간 " + minute + "분 " + second + "초]");
    }
}
