import java.util.Scanner;

/*
3.
7개의 정수를 입력받아 내림차순으로 정렬하는 프로그램을 만들어라
사용자가
6,9,15,3,2,11,20 입력했다면
20,15,11,9,6,3,2 출력되어야 한다.
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num[] = new int[7];
        System.out.println("정수 7개를 입력하세요. 각 정수는 공백으로 구분됩니다.");
        for (int i = 0; i < 7; i++) {
            num[i] = sc.nextInt();
        }
        while(true){
            int count = 0;
            int temp;
            for (int i = 0; i < 6; i++) {
                if(num[i]<num[i+1]){
                    temp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = temp;
                    count++;
                }
            }
            if(count==0) break;
        }
        String result = "";
        for (int i = 0; i < 7; i++) {
            result = result + " " + num[i];
        }
        System.out.println(result);
    }
}
