package GameCode;

import java.util.Arrays;
import java.util.Scanner;

public class Turn {
    boolean[][] movable = new boolean[8][8];


    public void turn(String[][] board, int[][] chessPiece, int[][] color, Scanner sc, int turnColor){
        String input = sc.nextLine();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j<8; j++){
                if(board[i][j].equals(input) && color[i][j] == turnColor){
                    checkMove(i, j, turnColor, chessPiece[i][j], chessPiece);
                    return;
                }
            }
        }

        System.out.println("올바른 위치를 입력 해 주십시오.");
        turn(board, chessPiece, color, sc, turnColor);
    }

    private void checkMove(int y, int x, int turnColor, int movePiece, int[][] chessPiece) {
        for (int i = 0; i < 8; i++) {
            Arrays.fill(movable[i], false);
        }
        switch(movePiece){
            case 1 :
                int dy = (turnColor ==1 ) ? -1 : 1;
                if(y+dy>=0 && y+dy <=7 && chessPiece[y+dy][x]==0){
                    movable[y+dy][x] == true;
                }
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :

        }
    }
}
