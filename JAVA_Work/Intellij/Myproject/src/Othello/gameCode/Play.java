package Othello.gameCode;

import java.util.Scanner;

public class Play {
    public void play(Scanner sc) {
        GameBoard game = new GameBoard();
        CheckRoom checkRoom = new CheckRoom();
        Turn turn = new Turn();
        Flip flip = new Flip();
        ResultCount resultCount = new ResultCount();
        CheckState checkState = new CheckState();
        System.out.println("게임을 시작합니다.");
        if ((int) (Math.random() * 2) == 0) {
            System.out.println("선공입니다.");
            } else {
            System.out.println("후공입니다.");
            checkRoom.checkBlack(game.room);
            game.printBlack(checkRoom.black);
            turn.comTurn(game.room, checkRoom.inputList, flip);
        }

        while (true) {
            checkRoom.checkWhite(game.room);
            if (!checkRoom.inputList.isEmpty()) {
                game.printWhite(checkRoom.white);
                System.out.println("플레이어의 턴입니다.");
                turn.playerTurn(game.room, checkRoom.inputList, sc, flip);
            }

            if(resultCount.doCount(checkState, game.room)) break;

            checkRoom.checkBlack(game.room);
            if (!checkRoom.inputList.isEmpty()) {
                game.printBlack(checkRoom.black);
                System.out.println("컴퓨터의 턴입니다.");
                turn.comTurn(game.room, checkRoom.inputList, flip);
            }

            if(resultCount.doCount(checkState, game.room)) break;

        }

    }
    //게임 시작


    //printWhite
    //선후공 결정
    //후공 시에 컴퓨터 턴 진행

    //게임이 끝날 때 까지
        /*
        플레이어 턴{
        1. 입력받음
        2. printWhite}

        컴퓨터 턴{
        1. 컴퓨터 턴 진행
        2. printWhite}
         */

    //끝
}
