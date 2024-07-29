package GameCode;

import java.util.Arrays;
import java.util.Scanner;

public class Turn {
    public boolean[][] movable = new boolean[8][8];

    public int turn(Turn turn, GameBoard board, int[][] chessPiece, int[][] color, Scanner sc, int turnColor) {

        if (Check.checkBy(chessPiece, color, 2 / turnColor)) {
            if (CheckMate.checkAll(turn, turnColor, chessPiece, color, board.board)) {
                System.out.println("체크메이트입니다. Player" + 2 / turnColor + "의 승리입니다.");
                return 2 / turnColor;
            }
            System.out.println("현재 체크 당한 상태입니다!");
        }
        System.out.println("이동시킬 말의 위치를 골라 주세요");
        String input = sc.nextLine();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.board[i][j].equals(input) && color[i][j] == turnColor) {
                    checkMove(i, j, turnColor, chessPiece[i][j], chessPiece, color);
                    board.printBoard(movable);
                    if (doMove(i, j, chessPiece, sc, board.board, color, turnColor, chessPiece[i][j])) {
                        return 0;
                    } else {
                        turn(turn, board, chessPiece, color, sc, turnColor);
                        return 0;
                    }
                }
            }
        }

        System.out.println("올바른 위치를 입력 해 주십시오.");
        turn(turn, board, chessPiece, color, sc, turnColor);
        return 0;
    }

    public void checkMove(int y, int x, int turnColor, int movePiece, int[][] chessPiece, int[][] color) {
        int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};

        for (int i = 0; i < 8; i++) {
            Arrays.fill(movable[i], false);
        }

        switch (movePiece) {
            case 1:
                int Pdy = (turnColor == 1) ? 1 : -1;
                if (y + Pdy >= 0 && y + Pdy <= 7 && chessPiece[y + Pdy][x] == 0) {
                    movable[y + Pdy][x] = true;
                }
                if (((y == 1 && turnColor == 1) || (y == 6 && turnColor == 2)) && chessPiece[y + Pdy][x] == 0 && chessPiece[y + Pdy + Pdy][x] == 0) {
                    movable[y + Pdy + Pdy][x] = true;
                }
                if (y + Pdy >= 0 && y + Pdy <= 7 && x + 1 <= 7
                        && chessPiece[y + Pdy][x + 1] == 1
                        && color[y + Pdy][x + 1] == 2 / turnColor) {
                    movable[y + Pdy][x + 1] = true;
                }
                if (y + Pdy >= 0 && y + Pdy <= 7 && x - 1 >= 0
                        && chessPiece[y + Pdy][x - 1] == 0
                        && color[y + Pdy][x - 1] == 2 / turnColor) {
                    movable[y + Pdy][x - 1] = true;
                }
                break;
            case 2:
                for (int i = 0; i < 4; i++) {
                    checkStraight(y, x, turnColor, dy[i], dx[i], chessPiece, color);
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    if (y + dy[i] + dy[i + 4] >= 0 && y + dy[i] + dy[i + 4] <= 7
                            && x + dx[i] + dx[i + 4] >= 0 && x + dx[i] + dx[i + 4] <= 7) {

                        if (color[y + dy[i] + dy[i + 4]][x + dx[i] + dx[i + 4]] != turnColor) {
                            movable[y + dy[i] + dy[i + 4]][x + dx[i] + dx[i + 4]] = true;
                        }
                    }
                    if (y + dy[i] + dy[i + 5] >= 0 && y + dy[i] + dy[i + 5] <= 7
                            && x + dx[i] + dx[i + 5] >= 0 && x + dx[i] + dx[i + 5] <= 7) {
                        if (color[y + dy[i] + dy[i + 5]][x + dx[i] + dx[i + 5]] != turnColor) {
                            movable[y + dy[i] + dy[i + 5]][x + dx[i] + dx[i + 5]] = true;
                        }
                    }
                }
                if (y - 1 >= 0 && y + 1 <= 7 && x - 2 >= 0) {
                    if (color[y - 1][x - 2] != turnColor) {
                        movable[y - 1][x - 2] = true;
                    }
                    if (color[y + 1][x - 2] != turnColor) {
                        movable[y + 1][x - 2] = true;
                    }
                }
                break;

            case 4:
                for (int i = 4; i < 8; i++) {
                    checkStraight(y, x, turnColor, dy[i], dx[i], chessPiece, color);
                }
                break;
            case 5:
                for (int i = 0; i < 8; i++) {
                    checkStraight(y, x, turnColor, dy[i], dx[i], chessPiece, color);
                }
                break;
            case 6:


                for (int i = 0; i < 8; i++) {
                    if (y + dy[i] >= 0 && y + dy[i] <= 7 && x + dx[i] >= 0 && x + dx[i] <= 7) {
                        if (color[y + dy[i]][x + dx[i]] != turnColor) {
                            movable[y + dy[i]][x + dx[i]] = true;
                        }
                    }
                }
                break;

        }
    }

    private void checkStraight(int y, int x, int turnColor, int dy, int dx, int[][] chessPiece, int[][] color) {
        if (y + dy < 0 || y + dy > 7 || x + dx < 0 || x + dx > 7) {
            return;
        }
        if (chessPiece[y + dy][x + dx] == 0) {
            movable[y + dy][x + dx] = true;
            checkStraight(y + dy, x + dx, turnColor, dy, dx, chessPiece, color);
            return;
        } else if (color[y + dy][x + dx] != turnColor) {
            movable[y + dy][x + dx] = true;
            return;
        } else return;

    }

    private boolean doMove(int y, int x, int[][] chessPiece, Scanner sc, String[][] board, int[][] color, int turnColor, int movePiece) {
        System.out.println("말을 이동시킬 위치를 골라 주십시오");
        String input = sc.nextLine();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(input) && movable[i][j]) {
                    int tempPieceBefore = chessPiece[y][x];
                    int tempColorBefore = color[y][x];
                    int tempPieceAfter = chessPiece[i][j];
                    int tempColorAfter = color[i][j];
                    chessPiece[y][x] = 0;
                    color[y][x] = 0;
                    chessPiece[i][j] = movePiece;
                    color[i][j] = turnColor;
                    if (!Check.checkBy(chessPiece, color, 2 / turnColor)) {
                        System.out.printf("%s -> %s\n", board[y][x], board[i][j]);
                        System.out.printf("%d %d %d %d\n", chessPiece[y][x], color[y][x], chessPiece[i][j], color[i][j]);
                        for (int k = 0; k < 8; k++) {
                            Arrays.fill(movable[k], false);
                        }
                        return true;
                    } else {
                        System.out.println("자기 자신을 체크 상태로 만들 수 없습니다!");
                        chessPiece[i][j] = tempPieceAfter;
                        color[i][j] = tempColorAfter;
                        chessPiece[y][x] = tempPieceBefore;
                        color[y][x] = tempColorBefore;
                        for (int k = 0; k < 8; k++) {
                            Arrays.fill(movable[i], false);
                        }
                        return false;
                    }
                }
            }
        }
        System.out.println("올바른 위치를 입력 해 주십시오");

        for (int i = 0; i < 8; i++) {
            Arrays.fill(movable[i], false);
        }

        return false;

    }

}
