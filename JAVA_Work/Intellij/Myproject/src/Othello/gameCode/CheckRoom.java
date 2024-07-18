package Othello.gameCode;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckRoom {
    boolean[][] white = new boolean[8][8]; // 백이 놓을 수 있는 공간 기록
    boolean[][] black = new boolean[8][8]; // 흑이 놓을 수 있는 공간 기록
    int[] y = {-1, 0, 1, 0, -1, -1, 1, 1}; //위, 우측, 아래, 좌측, 대각선 순서대로 확인
    int[] x = {0, 1, 0, -1, -1, 1, -1, 1}; //마찬가지
    ArrayList<Integer> inputList = new ArrayList<>(); //놓을 수 있는 좌표 기록

    public void checkWhite(int[][] room) {
        for (int i = 0; i < 8; i++) {
            Arrays.fill(white[i], false);
        }
        inputList.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //게임판을 스캔하다가
                if (room[i][j] == 1) {//백돌을 만나면
                    for (int k = 0; k < 8; k++) { //상하좌우 대각선 순서대로 스캔
                        if(i+y[k]<0||j+x[k]<0) continue; //게임판의 범위를 벗어나면 스킵
                        if(i+y[k]>7||j+x[k]>7) continue; //게임판의 범위를 벗어나면 스킵
                        if (room[i + y[k]][j + x[k]] == 2) { //흑돌이면
                            //그쪽 방향으로 진행하면서 체크하는 메서드
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
                //게임판을 스캔하다가
                if (room[i][j] == 2) {//흑돌을 만나면
                    for (int k = 0; k < 8; k++) { //상하좌우 대각선 순서대로 스캔하는데
                        if(i+y[k]<0||j+x[k]<0) continue;//게임판의 범위를 벗어나면 스킵
                        if(i+y[k]>7||j+x[k]>7) continue;//게임판의 범위를 벗어나면 스킵
                        if (room[i + y[k]][j + x[k]] == 1) { //백돌을 찾으면
                            //그쪽 방향으로 진행하면서 체크하는 메서드
                            check(room, i + y[k], j + x[k], 2, y[k], x[k]);
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
                    inputList.add((down + y) * 8 + right + x + 1); //위치 기록
                } else { //흑돌일 경우
                    black[down + y][right + x] = true; //흑돌을 놓을 수 있음
                    inputList.add((down + y) * 8 + right + x + 1); //위치 기록
                }
                return; //종료
            }
            //공백이 아니라면(상대방의 말이라면) 계속 진행
            check(room, down + y, right + x, color, y, x);
        }
    }
}
/*
ex) 백색의 턴
1. 게임판에서 백돌을 찾는다.
2. 백돌과 인접한 흑돌을 찾는다.
3. 흑돌을 찾으면 그 방향으로 진행하면서
4. 흑돌일 경우 계속 진행
5. 백돌일 경우 그냥 종료(백돌을 놓을 수 없음)
6. 빈 칸일 경우 백돌을 놓을 수 있는 자리이므로 자리를 기록하고 종료
 */

/*
ex) 백(1)-흑(1)-흑(2)-공백(1)
1. 백(1)을 찾음
2. 흑(1)이 우측에 있음
3. 우측으로 진행하면서 다음 돌을 확인
4. 흑(2)를 찾았으므로 3번으로 재귀
=우측으로 진행하면서 다음 돌을 확인
5. 공백(1)을 찾았으므로, white[][](공백의 좌표)=true; 하고
    inputList에 공백의 좌표를 기록하고 종료 .
 */
