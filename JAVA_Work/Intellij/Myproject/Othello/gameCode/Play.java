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
            checkRoom.checkRoom(game.room, 2);
            game.printBoard(checkRoom.black);
            turn.comTurn(game.room, checkRoom.inputList, flip);
        }

        while (true) {
            //백이 놓을 수 있는 공간 확인
            System.out.println("플레이어의 턴입니다.");
            checkRoom.checkRoom(game.room, 1);
            if (checkRoom.inputList.length!=0) { //백이 놓을 수 있는 공간이 있으면
                game.printBoard(checkRoom.white); // 백 게임판 출력
                turn.playerTurn(game.room, checkRoom.inputList, sc, flip); // 플레이어 턴 진행
            }
            else{
                System.out.println("놓을 수 있는 공간이 없어 턴이 패스됩니다.");
            }

            if (resultCount.doCount(checkState, game.room)) break; //게임이 끝나면 break

            System.out.println("컴퓨터의 턴입니다.");
            checkRoom.checkRoom(game.room, 2); // 흑이 놓을 수 있는 공간 확인
            if (checkRoom.inputList.length!=0) { // 공간이 있으면
                game.printBoard(checkRoom.black); // 흑 게임판 출력
                turn.comTurn(game.room, checkRoom.inputList, flip); //컴퓨터 턴 진행
            }
            else{
                System.out.println("놓을 수 있는 공간이 없어 턴이 패스됩니다.");
            }

            if (resultCount.doCount(checkState, game.room)) break; //게임이 끝나면 break

        }

    }
}