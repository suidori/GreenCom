package Othello.gameCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckRoom {
    boolean[][] white = new boolean[8][8];
    boolean[][] black = new boolean[8][8];
    int[] y = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] x = {0, 1, 0, -1, -1, 1, -1, 1};
    ArrayList<Integer> inputList = new ArrayList<>();

    public void checkWhite(int[][] room) {
        for (int i = 0; i < 8; i++) {
            Arrays.fill(white[i], false);
        }
        inputList.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (room[i][j] == 1) {//백돌이면
                    for (int k = 0; k < 8; k++) { //상하좌우 순서대로
                        if (room[i + y[k]][j + x[k]] == 2) { //흑돌이면
                            //그쪽 방향 체크
                            check(room, i + y[k], j + x[k], 1, y[k], x[k]);
                        }
                    }
                }
            }
        }
    }

    public void checkBlack(int[][] room) {
        for (int i = 0; i < 8; i++) {
            Arrays.fill(black[i], false);
        }
        inputList.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (room[i][j] == 2) {//흑돌이면
                    for (int k = 0; k < 8; k++) { //상하좌우 순서대로
                        if (room[i + y[k]][j + x[k]] == 1) { //백돌이면
                            //그쪽 방향 체크
                            check(room, i + y[k], j + x[k], 2, y[k], x[k]);
                        }
                    }
                }
            }
        }
    }

    private void check(int[][] room, int down, int right, int color, int y, int x) {
        if (y == -1 && down == 0) {
            return;
        } else if (x == 1 && right == 7) {
            return;
        } else if (y == 1 && down == 7) {
            return;
        } else if (x == -1 && right == 0) {
            return;
        }

        if (room[down + y][right + x] != color) {
            if (room[down + y][right + x] == 0) {
                if (color == 1) {
                    white[down + y][right + x] = true;
                    inputList.add((down + y) * 8 + right + x + 1);
                } else {
                    black[down + y][right + x] = true;
                    inputList.add((down + y) * 8 + right + x + 1);
                }
                return;
            }
            check(room, down + y, right + x, color, y, x);
        } else {
            return;
        }
    }
}

