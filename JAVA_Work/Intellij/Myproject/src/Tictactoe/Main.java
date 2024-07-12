package Tictactoe;

import Tictactoe.gameCode.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScan = new Scanner(System.in);
        System.out.println("틱택토 게임을 시작합니다.");
        System.out.println("게임의 설명을 들으시겠습니까? (y/n)");
        int[] result = new int[3]; //result 참조변수(승, 무, 패)
        while (rule(mainScan.nextLine()));//y나 n을 입력할 때 까지 반복
        boolean[] replay = {true};
        while (replay[0]) {

            Play.play(result); //게임플레이(result 참조변수 대입)

            System.out.println("다시 플레이하시겠습니까? (y/n)");

            while(replay(mainScan.nextLine(), replay)){}//y나 n을 받을 때까지 반복.

        }
        System.out.println("게임이 종료되었습니다.");
        System.out.printf("최종 스코어 : [ %d승, %d무, %d패 ]", result[1], result[0], result[2]); //result 참조하여 승 무 패 출력
        mainScan.close();
    }

    public static boolean rule(String input) {
        if (input.equals("y")) {
            System.out.println("1. 당신은 가상의 상대와 대결하게 됩니다.");
            System.out.println("2. 3X3 모양의 공간이 주어집니다.");
            System.out.println("3. 서로 돌아가면서 자신의 기호로 칸을 채웁니다.");
            System.out.println("4. 가로,세로,대각선 중 한 줄을 먼저 채운 사람이 승리합니다.");
            System.out.println("5. 당신의 기호는 'O' 이고, 상대의 기호는 'X' 입니다.");
            System.out.println("6. 1~9에 해당하는 숫자를 입력해서 칸을 채웁니다.\n");
            return false; //y를 입력함(break)
        } else if (input.equals("n")) {
            return false; //n을 입력함(break)
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            return true; //잘못된 값을 입력함
        }
    }

    public static boolean replay(String input, boolean[] replay){
        switch (input) {
            case "y": //y 입력 시 재시작
                replay[0] = true;
                return false;
            case "n":
                replay[0] = false;
                return false; // n 입력 시 종료
            default:
                System.out.println("y나 n을 입력해 주세요.");
                return true; // y나 n 대신 다른 값 입력 시 반복
        }
    }

}

//Main code