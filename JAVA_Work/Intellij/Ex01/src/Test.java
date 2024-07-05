import java.util.Scanner;

/*
    1. 두 개의 주사위 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를
    출력하는 프로그램을 작성하시오.
    2. Math.random을 이용해서 1부터 6 사이의 임의의 정수를
    변수 value에 저장하는 코드를 완성하여라
 */
public class Test {

    public static void solution1(){
        for(int i = 1; i<=6; i++){
            for(int j = 1; j<=6; j++){
                if(i+j ==6){
                    System.out.print("[ "+ i +" , " + j + " ] " );
                }
                System.out.println();
            }
        }
    }

    public static void solution2(){

        int value = (int)((Math.random()*5)+1);
        System.out.println(value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 번 문제의 정답을 출력합니까?");

        int a = sc.nextInt();
        switch (a){

            case(1):
                solution1();
                break;

            case(2):
                solution2();
                break;

            default :
                break;

        }
        System.out.println("프로그램 종료");
    }

}


