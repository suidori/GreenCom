package Tictactoe.gameCode;

import java.util.Scanner;

public class Play {
    public static void play(State state, Scanner sc) {
        System.out.println("게임을 시작합니다.");
        Game g = new Game(); //Game 클래스
        if (g.start()) { //랜덤 함수를 이용해 선공과 후공을 결정
            System.out.println("선공입니다.");
            g.view();
        } else {
            System.out.println("후공입니다.");
            g.comTurn(); //후공 시 컴퓨터의 턴 먼저 진행
        }
        while (true) { //게임이 끝날 때 까지 반복
            System.out.println("\n플레이어의 턴입니다.");
            if (!g.playerTurn(sc.nextInt())) continue; //플레이어의 턴을 진행하면서, 잘못된 값을 입력 시 반복
            if (g.result(state)) break; //게임 완료 조건 달성 시 break

            g.comTurn(); //컴퓨터의 턴(컴퓨터는 잘못된 값을 입력하지 않는다.)
            if (g.result(state)) break; //게임 완료 조건 달성 시 break
        }
    }
}

//Play code