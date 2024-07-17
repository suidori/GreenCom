package Othello.gameCode;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameBoard game = new GameBoard();
        CheckRoom checkRoom = new CheckRoom();
        Input turn = new Input();
        Flip flip = new Flip();

        while(true) {
            checkRoom.checkWhite(game.room);
            game.printWhite(checkRoom.white);
            turn.playerTurn(game.room, checkRoom.inputList, sc, flip);

            checkRoom.checkBlack(game.room);
            game.printBlack(checkRoom.black);
            turn.comTurn(game.room, checkRoom.inputList, flip);
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
