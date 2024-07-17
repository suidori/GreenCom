package Tictactoe.gameCode;

import java.util.Scanner;

public class Play {
    public void play(Scanner sc, Count count) {
        System.out.println("게임을 시작합니다.");
        Game g = new Game(); //GameBoard 클래스
        Progress p = new Progress();
        if ((int) (Math.random() * 2) == 0) { //랜덤 함수를 이용해 선공과 후공을 결정
            System.out.println("선공입니다.");
            p.view(g.room);
        } else {
            System.out.println("후공입니다.");
            p.comTurn(g, p); //후공 시 컴퓨터의 턴 먼저 진행
        }
        while (true) { //게임이 끝날 때 까지 반복
            p.playerTurn(g, sc, p); //플레이어의 턴을 진행하면서, 잘못된 값을 입력 시 반복
            if (count.doCount(g, g.draw)) break; //게임 완료 조건 달성 시 break

            p.comTurn(g, p); //컴퓨터의 턴(컴퓨터는 잘못된 값을 입력하지 않는다.)
            if (count.doCount(g, g.draw)) break; //게임 완료 조건 달성 시 break
        }
    }
}

//Play code