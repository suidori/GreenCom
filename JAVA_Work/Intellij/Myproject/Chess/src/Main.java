import GameCode.GameBoard;
import GameCode.Turn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();
        Turn turn = new Turn();
        Scanner sc = new Scanner(System.in);
        int turnColor = 1;

        while (true) {
            gameBoard.printBoard(turn.movable);
            if(turn.turn(turn, gameBoard, gameBoard.chessPiece, gameBoard.color, sc, turnColor)!=0){
                break;
            }
            turnColor = 2 / turnColor;
        }
    }
}
