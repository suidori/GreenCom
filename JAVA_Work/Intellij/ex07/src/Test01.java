import java.util.Arrays;
import java.util.Scanner;

class solution{
    public static void solution1(Scanner sc){
        System.out.println("문자열을 입력 해 주세요.");
        String input = sc.next();
        char[] chars = input.toCharArray();

        for(char e: chars){
            System.out.println(e);
        }
    }

    public static void solution2(){
        int[][] arr = new int[4][5];
        Arrays.fill(arr[0], 5);
        Arrays.fill(arr[1], 10);
        Arrays.fill(arr[2], 20);
        Arrays.fill(arr[3], 30);
        int sum = 0;
        int avr = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                sum += arr[i][j];
            }
        }
        avr = sum/arr.length;
        System.out.println("합은 " + sum + "입니다.");
        System.out.println("평균은 " +avr + "입니다.");
    }
    public static void solution3(){
        int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
        int[] count = new int[9];
        for (int i = 0; i < answer.length; i++) {
            count[answer[i]-1]++;
        }
        for (int i = 0; i < 9; i++) {
            if(count[i]!=0) {
                System.out.print(i + 1);
                for (int j = 0; j < count[i]; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 번 문제의 정답을 출력하시겠습니까?");
        switch(sc.nextInt()){
            case 1: solution.solution1(sc);
            break;
            case 2: solution.solution2();
            break;
            case 3: solution.solution3();
            break;
            default: break;
        }
    }
}
