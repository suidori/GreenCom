package Othello.gameCode;

import java.util.Arrays;

public class Flip {
    int[] y = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] x = {0, 1, 0, -1, -1, 1, -1, 1};
    int[][] coordinate = new int[6][2];


    public void doFlip(int[][] room, int down, int right, int color){
        for (int i = 0; i < 8; i++) {
            //게임판을 벗어나면 스킵
            if (y[i] == -1 && down == 0) {
                continue;
            } else if (x[i] == 1 && right == 7) {
                continue;
            } else if (y[i] == 1 && down == 7) {
                continue;
            } else if (x[i] == -1 && right == 0) {
                continue;
            }
            //내가 놓은 말과 인접한, 다른 색의 말을 체크함
            if (room[down + y[i]][right + x[i]] != color) {
                //뒤집을 말의 좌표를 초기화
                for (int j = 0; j < 6; j++) {
                    Arrays.fill(coordinate[j], 0);
                }
                //주어진 방향으로 진행하면서 뒤집을 말의 좌표를 기록하는 함수
                check(room, down + y[i], right + x[i], color, y[i], x[i], 0);
            }
        }
    }

    private void check(int[][] room, int down, int right, int color, int y, int x, int cycle){
        //게임판을 벗어나면 종료
        if (y == -1 && down == 0) {
            return;
        } else if (x == 1 && right == 7) {
            return;
        } else if (y == 1 && down == 7) {
            return;
        } else if (x == -1 && right == 0) {
            return;
        }
        //주어진 방향으로 진행하면서
        //턴 플레이어가 놓은 말이 없는 공간을 만났을 때
        if (room[down + y][right + x] != color) {
            //그 칸이 공백이면
            if (room[down + y][right + x] == 0) {
                //감싸는 형태가 아니므로 종료
                return;
                }
          else {
              //공백이 아니라면(상대편의 말이라면) 뒤집을 수 있는 말이므로
              coordinate[cycle] = new int[]{down, right}; //좌표를 기록하고
                //계속 진행(재귀)
              check(room, down+y, right+x, color, y, x, cycle+1);
          }
          return;
        }
        else{
            //나와 같은 색의 말을 만나면
            room[down][right] = color; //check를 시작한 시점의 말을 뒤집고
            //이후 좌표가 기록된 말들도 뒤집음
            for (int i = 0; i < cycle; i++) {
                room[coordinate[i][0]][coordinate[i][1]] = color;
            }
        }
    }

}

//체크해서
//다른 색깔 돌이고
//반대편에 같은 색 돌 있으면
//뒤집기