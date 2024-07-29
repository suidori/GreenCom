package GameCode;

public class CheckMate {
    public static boolean checkAll(Turn turn, int turnColor, int[][] chessPiece, int[][] color, String[][] board) {
        int checkMate = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (color[i][j] == turnColor) {
                    turn.checkMove(i, j, turnColor, chessPiece[i][j], chessPiece, color);

                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (turn.movable[k][l]) {
                                int tempPieceBefore = chessPiece[i][j];
                                int tempColorBefore = color[i][j];
                                int tempPieceAfter = chessPiece[k][l];
                                int tempColorAfter = color[k][l];

                                chessPiece[k][l] = chessPiece[i][j];
                                color[k][l] = turnColor;

                                chessPiece[i][j] = 0;
                                color[i][j] = 0;
                                if (!Check.checkBy(chessPiece, color, 2 / turnColor)) {
                                    System.out.printf("놓을 수 있는 수: %s -> %s\n", board[i][j], board[k][l]);
                                    checkMate++;
                                }
                                chessPiece[i][j] = tempPieceBefore;
                                color[i][j] = tempColorBefore;
                                chessPiece[k][l] = tempPieceAfter;
                                color[k][l] = tempColorAfter;
                            }
                        }
                    }
                }
            }

        }
        return checkMate == 0;
    }
}
