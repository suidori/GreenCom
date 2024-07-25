import GameCode.Check;
import GameCode.GameBoard;
import GameCode.Turn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        Turn turn = new Turn();
        Scanner sc = new Scanner(System.in);
        Check check = new Check();
        int turnColor = 1;

        while (true) {
            gameBoard.printBoard(turn.movable);
            turn.turn(gameBoard, gameBoard.chessPiece, gameBoard.color, sc, turnColor);

            if (check.checkBy(gameBoard.chessPiece, gameBoard.color, turnColor)) {
                System.out.printf("player %d가 체크 당했습니다!", 2/turnColor);
                break;
            }

            turnColor = 2 / turnColor;

        }
    }
}
