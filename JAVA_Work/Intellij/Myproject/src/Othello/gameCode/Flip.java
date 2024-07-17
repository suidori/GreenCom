package Othello.gameCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {
    int[] y = {-1, 0, 1, 0, -1, -1, 1, 1};
    int[] x = {0, 1, 0, -1, -1, 1, -1, 1};
    int[][] coordinate = new int[6][2];


    public void doFlip(int[][] room, int down, int right, int color){
        for (int i = 0; i < 8; i++) {
            if (y[i] == -1 && down == 0) {
                continue;
            } else if (x[i] == 1 && right == 7) {
                continue;
            } else if (y[i] == 1 && down == 7) {
                continue;
            } else if (x[i] == -1 && right == 0) {
                continue;
            }
            if (room[down + y[i]][right + x[i]] != color) {
                for (int j = 0; j < 6; j++) {
                    Arrays.fill(coordinate[j], 0);
                }
                check(room, down + y[i], right + x[i], color, y[i], x[i], 0);
            }
        }
    }

    private void check(int[][] room, int down, int right, int color, int y, int x, int cycle){
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
                return;
                }
          else {
              coordinate[cycle] = new int[]{down, right};
              check(room, down+y, right+x, color, y, x, cycle+1);
          }
          return;
        }
        else{
            room[down][right] = color;
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