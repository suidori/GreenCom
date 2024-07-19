package GameCode;

import java.util.Arrays;
import java.util.Scanner;

public class Turn {
    public void playerTurn(ScoreBoard scoreBoard, PutScore ps, int player){
        Scanner sc = new Scanner(System.in);
        RollDice a = new RollDice();
        System.out.println("Player" + player + " 의 차례입니다.");
        a.rollDice(a, sc);
        scoreBoard.printBoard();
        System.out.println(Arrays.toString(a.diceKeep));
        ps.putScore(scoreBoard.board, a.diceKeep, sc, player);
    }
}
