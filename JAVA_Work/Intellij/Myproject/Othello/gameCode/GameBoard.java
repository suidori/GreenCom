package Othello.gameCode;

public class GameBoard {
    int[][] room = new int[8][8];


    public GameBoard() {
        //게임판 초기화
        room[3][3] = 1;
        room[4][3] = 2;
        room[3][4] = 2;
        room[4][4] = 1;
    }

    public void printBoard(boolean[][] space) {
        char player = '○'; //플레이어의 기호
        char com = '●'; //컴퓨터의 기호
        int k = 1; //숫자 출력을 위한 변수
        System.out.println("\n=========================================="); // 가로선 출력
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (room[i][j] == 1) { //room 이 1(플레이어의 칸)이라면
                    System.out.print(" " + player + " ");//O를 출력

                } else if (room[i][j] == 2) {//room 이 2(컴퓨터의 칸) 이라면
                    System.out.print(" " + com + " ");//X를 출력

                } else {//둘 다 아니면(빈칸이라면)
                    System.out.print((space[i][j]) ? " " + (i + j + k) : "     "); //놓을 수 있는 칸의 경우에만 숫자 출력
                }
                if (j == 7) break; //마지막 줄에는 세로선 출력하지 않음
                System.out.print(" | "); //기호나 숫자 중간에 세로선 설치

            }
            System.out.println("\n=========================================="); // 가로선 출력

            k += 7;
        }
        System.out.println(" ");
    }
}