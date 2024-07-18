package Othello.gameCode;

import java.util.Scanner;

public class Play {

    GameBoard game = new GameBoard();
    CheckRoom checkRoom = new CheckRoom();
    Turn turn = new Turn();
    Flip flip = new Flip();
    CheckState checkState = new CheckState();

    public void play (Scanner sc, ResultCount resultCount) {

        System.out.println("게임을 시작합니다.");
        if ((int) (Math.random() * 2) == 0) { //랜덤 함수로 0 아니면 1 출력
            System.out.println("선공입니다."); // 0은 선공
        } else {
            System.out.println("후공입니다."); //1은 후공
            //후공이면 컴퓨터의 턴 진행
            checkRoom.checkBlack(game.room);
            game.printBlack(checkRoom.black);
            turn.comTurn(game.room, checkRoom.inputList, flip);
        }

        while (true) {
            //백이 놓을 수 있는 공간 확인
            checkRoom.checkWhite(game.room);
            if (!checkRoom.inputList.isEmpty()) { //백이 놓을 수 있는 공간이 있으면
                game.printWhite(checkRoom.white); // 백 게임판 출력
                System.out.println("플레이어의 턴입니다.");
                turn.playerTurn(game.room, checkRoom.inputList, sc, flip); // 플레이어 턴 진행
            }

            if (resultCount.doCount(checkState, game.room, checkState.player, checkState.com)) break; //게임이 끝나면 break

            checkRoom.checkBlack(game.room); // 흑이 놓을 수 있는 공간 확인
            if (!checkRoom.inputList.isEmpty()) { // 공간이 있으면
                game.printBlack(checkRoom.black); // 흑 게임판 출력
                System.out.println("컴퓨터의 턴입니다.");
                turn.comTurn(game.room, checkRoom.inputList, flip); //컴퓨터 턴 진행
            }

            if (resultCount.doCount(checkState, game.room, checkState.player, checkState.com)) break; //게임이 끝나면 break

        }

    }
}