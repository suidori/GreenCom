package Othello.gameCode;

import java.util.Arrays;

public class CheckRoom {
    boolean[][] white = new boolean[8][8]; // 백이 놓을 수 있는 공간 기록
    boolean[][] black = new boolean[8][8]; // 흑이 놓을 수 있는 공간 기록
    int[] y = {-1, 0, 1, 0, -1, -1, 1, 1}; //위, 우측, 아래, 좌측, 대각선 순서대로 확인
    int[] x = {0, 1, 0, -1, -1, 1, -1, 1}; //마찬가지
    int[] inputList; //놓을 수 있는 좌표 기록

    public void checkRoom(int[][] room, int color) {
        inputList = new int[0];
        for (int i = 0; i < 8; i++) {
            Arrays.fill((color == 1) ? white[i] : black[i], false);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //게임판을 스캔하다가
                if (room[i][j] == color) {//color 돌을 만나면
                    for (int k = 0; k < 8; k++) { //상하좌우 대각선 순서대로 스캔
                        if (i + y[k] >= 0 && j + x[k] >= 0 && i + y[k] <= 7 && j + x[k] <= 7) {
                            if (room[i + y[k]][j + x[k]] == 2 / color) { //상대 돌을 만나면
                                //그쪽 방향으로 진행하면서 체크하는 메서드
                                check(room, i + y[k], j + x[k], color, y[k], x[k]);
                            }
                        }
                    }
                }
            }
        }
    }

    private void check(int[][] room, int down, int right, int color, int y, int x) {
        //게임판의 범위를 벗어나면 탈출
        if (y == -1 && down == 0) {
            return;
        } else if (x == 1 && right == 7) {
            return;
        } else if (y == 1 && down == 7) {
            return;
        } else if (x == -1 && right == 0) {
            return;
        }

        //주어진 방향으로 진행한다
        if (room[down + y][right + x] != color) {//턴 플레이어의 색과 다른 색을 만났을 때
            if (room[down + y][right + x] == 0) {//빈 칸이면
                if (color == 1) { //백돌일 경우
                    white[down + y][right + x] = true; //백돌을 놓을 수 있음

                    //위치 기록
                    int[] temp = new int[inputList.length + 1];
                    System.arraycopy(inputList, 0, temp, 0, inputList.length);
                    temp[inputList.length] = (down + y) * 8 + right + x + 1;
                    inputList = temp;

                } else { //흑돌일 경우
                    black[down + y][right + x] = true; //흑돌을 놓을 수 있음

                    //위치 기록
                    int[] temp = new int[inputList.length + 1];
                    System.arraycopy(inputList, 0, temp, 0, inputList.length);
                    temp[inputList.length] = (down + y) * 8 + right + x + 1;
                    inputList = temp;
                }
                return; //종료
            }
            //공백이 아니라면(상대방의 말이라면) 계속 진행
            check(room, down + y, right + x, color, y, x);
        }
    }
}