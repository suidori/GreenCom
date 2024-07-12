package Tictactoe.gameCode;

import java.util.Scanner;

public class Play {
    public static void play(int[] result) {
        System.out.println("게임을 시작합니다.");
        Game g = new Game(); //Game 클래스
        int[][] room = new int[3][3]; //2차원 배열 선언(3*3 틱택토 그리드)
        Scanner sc = new Scanner(System.in);
        int[] draw = new int[1]; //무승부 카운트를 위한 참조변수 선언

        if (g.start()) { //랜덤 함수를 이용해 선공과 후공을 결정
            System.out.println("선공입니다.");
        } else {
            System.out.println("후공입니다.");
            g.comTurn(room, draw); //후공 시 컴퓨터의 턴 먼저 진행
        }
        while (true) { //게임이 끝날 때 까지 반복
            System.out.println("\n플레이어의 턴입니다.");
            if (!g.playerTurn(sc.nextInt(), room, draw)) continue; //플레이어의 턴을 진행하면서, 잘못된 값을 입력 시 반복
            if (result(g, room, draw, result)) break; //게임 완료 조건 달성 시 break

            g.comTurn(room, draw); //컴퓨터의 턴(컴퓨터는 잘못된 값을 입력하지 않는다.)
            if (result(g, room, draw, result)) break; //게임 완료 조건 달성 시 break
        }
        sc.close();
    }

    public static boolean result(Game g, int[][] room, int[] draw, int[] result) {
        if (g.result(room) == 2) { //컴퓨터의 승리 조건
            System.out.println("\n\n컴퓨터의 승리입니다");
            result[2]++; //result[2] = 패배 카운트
            return true;
        } else if (g.result(room) == 1) { //플레이어의 승리 조건
            System.out.println("\n\n플레이어의 승리입니다");
            result[1]++; //result[1] = 승리 카운트
            return true;
        } else if (draw[0] == 9) { //무승부 조건
            System.out.println("무승부입니다.");
            result[0]++; //result[0] = 무승무 카운트
            return true;
        } else return false; //승리 조건 없을 시 return false
    }


}

//Play play code