package Tictactoe.gameCode;

import java.util.Scanner;

public class Game {
    int[][] room = new int[3][3]; //2차원 배열 선언(3*3 틱택토 그리드)
    int draw = 0; //무승부 카운트를 위한 변수 선언

    public void com() { //랜덤한 칸을 컴퓨터의 칸으로 만드는 함수
        int input = (int) (Math.random() * 9 + 1); //1~9 사이의 랜덤한 수 출력

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input == (i + j + k)) { //출력된 수와 같은 자리를 찾아서
                    if (room[i][j] == 0) {//빈칸이라면
                        room[i][j] = 2;//컴퓨터의 칸으로 만든다
                    } else {//빈칸이 아니라면
                        com();//다시 시도한다
                    }
                }
            }
            k += 2;
        }
    }

    public void player(Scanner sc) { //플레이어의 값을 입력받는 함수
        String str = sc.nextLine();
        if (str.isEmpty()) {
            System.out.println("1~9 사이의 숫자를 입력하세요.");
            player(sc);
            return;
        }
        String check1 = Character.toString(str.charAt(0));
        if (!check1.matches("[1-9]")) {
            System.out.println("1~9 사이의 숫자를 입력하세요.");
            player(sc);
            return;
        }

        if (str.length() > 1) {
            String check2 = Character.toString(str.charAt(1));
            if (check2.matches("[0-9]")) {
                System.out.println("1~9 사이의 숫자를 입력하세요.");
                player(sc);
                return;
            }
        }

        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (check1.matches("" + (i + j + k))) { //입력받은 값과 같은 자리를 찾아서
                    if (room[i][j] == 0) { // 빈 칸이라면
                        room[i][j] = 1; // 플레이어의 칸으로 만듬
                    } else {//빈 칸이 아니라면
                        System.out.println("비어 있는 칸을 입력하세요.");
                        player(sc);
                    }
                    return;
                }
            }
            k += 2;//2칸씩 뛰어넘음
        }
    }

    public int result() {
        for (int i = 0; i < 3; i++) {
            if ((room[0][i] == room[1][i]) && (room[1][i] == room[2][i]) && (room[0][i] != 0))//세로 3개가 같은 값이고, 0이 아니면
                return room[0][i]; // 그 값을 반환한다
            if ((room[i][0] == room[i][1]) && (room[i][1] == room[i][2]) && (room[i][0] != 0)) // 가로 3개가 같은 값이고, 0이 아니면
                return room[i][0]; // 그 값을 반환한다
        }
        if ((room[0][0] == room[1][1]) && (room[2][2] == room[1][1]) && (room[0][0] != 0)) // 대각선 3개가 같은 값이고, 0이 아니면
            return room[0][0]; // 그 값을 반환한다
        else if ((room[2][0] == room[1][1]) && (room[0][2] == room[1][1]) && (room[0][2] != 0))
            return room[0][2]; //대각선 반환 2

        return -1; //모두 아니라면 없는 값을 반환한다.
    }

}

//Play gameplay code