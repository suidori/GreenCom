package GameCode;

import java.util.Arrays;

public class GameBoard {
    public String[][] board = new String[8][8];
    public int[][] chessPiece = new int[8][8];
    public int[][] color = new int[8][8];

    public GameBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = String.format("%c%d", 'h' - j, i + 1);
            }
        }
        Arrays.fill(color[0], 1);
        Arrays.fill(color[1], 1);
        Arrays.fill(color[6], 2);
        Arrays.fill(color[7], 2);

        Arrays.fill(chessPiece[1], 1);
        Arrays.fill(chessPiece[6], 1);

        for (int i = 0; i < 3; i++) {
            chessPiece[0][i] = i + 2;
            chessPiece[0][7 - i] = i + 2;
            chessPiece[7][i] = i + 2;
            chessPiece[7][7 - i] = i + 2;
        }
        chessPiece[0][3] = 6;
        chessPiece[7][3] = 6;
        chessPiece[0][4] = 5;
        chessPiece[7][4] = 5;
    }

    public void printBoard(boolean[][] movable) {
        for (int i = 0; i < 8; i++) {
            System.out.print(i+1);
            for (int j = 0; j < 8; j++) {
                switch (chessPiece[i][j]) {
                    case 0:
                        System.out.print((movable[i][j]) ? " ◼ " : " ☐ ");
                        break;
                    case 1:
                        System.out.print((color[i][j]==1) ? " ♙ " : " ♟ ");
                        break;
                    case 2:
                        System.out.print((color[i][j]==1) ? " ♖ " : " ♜ ");
                        break;
                    case 3:
                        System.out.print((color[i][j]==1) ? " ♘ " : " ♞ ");
                        break;
                    case 4:
                        System.out.print((color[i][j]==1) ? " ♗ " : " ♝ ");
                        break;
                    case 5:
                        System.out.print((color[i][j]==1) ? " ♕ " : " ♛ ");
                        break;
                    case 6:
                        System.out.print((color[i][j]==1) ? " ♔ " : " ♚ ");
                        break;
                }
                if(j==7){break;}
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("    h |  g  |  f  |  e |  d  |  c |  b  |  a  ");

    }
}