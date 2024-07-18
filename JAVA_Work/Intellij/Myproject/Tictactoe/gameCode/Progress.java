package Tictactoe.gameCode;

import java.util.Scanner;

public class Progress {

    public void comTurn(Game g, Progress p) {
        System.out.println("\n컴퓨터의 턴입니다.");
        g.com(); //컴퓨터의 칸 채우기 진행
        p.view(g.room); // 결과 출력
        g.draw++; // 무승부 카운트 올림
    }

    public void playerTurn(Game g, Scanner sc, Progress p) {
        System.out.println("\n플레이어의 턴입니다.");
        g.player(sc);
        p.view(g.room); //옳은 값이라면 결과 출력
        g.draw++; //무승부 카운트 올림
    }

    public void view(int[][] room) { //게임 진행 상황 출력 함수
        char player = 'O'; //플레이어의 기호
        char com = 'X'; //컴퓨터의 기호
        int k = 1; //숫자 출력을 위한 변수

        for (int i = 0; ; i++) {

            for (int j = 0; ; j++) {

                String blank = "" + (i + j + k); //i+j+k = 1,2,3 -> 4,5,6 -> 7,8,9 를 출력함

                if (room[i][j] == 1) { //room 이 1(플레이어의 칸)이라면
                    System.out.print(player);//O를 출력

                } else if (room[i][j] == 2) {//room 이 2(컴퓨터의 칸) 이라면
                    System.out.print(com);//X를 출력

                } else {//둘 다 아니면(기본값이라면)
                    System.out.print(blank);//숫자 출력
                }
                if (j == 2) break; //마지막 줄에는 세로선 출력하지 않음
                System.out.print(" | "); //기호나 숫자 중간에 세로선 설치

            }
            if (i == 2) break; //마지막 줄에는 가로선 출력하지 않음
            System.out.println("\n=========="); //기호를 3번 출력할 때 마다 가로선 출력

            k += 2; //2개씩 뛰어넘음(1,2,3 다음에 4,5,6이 옴)
        }
        System.out.println(" ");
    }
}
