package Tictactoe;

import java.util.Scanner;

public class TTT {
    public static void main(String[] args) {
        System.out.println("새로운 시작\n");
        Game g = new Game();
        int[][] room = new int[3][3];
        g.view(room);
        Scanner sc = new Scanner(System.in);
        int draw = 0;

        if (g.start()) {
            System.out.println("선공입니다.");
        } else {
            System.out.println("후공입니다.");
            System.out.println("\n컴퓨터의 턴입니다.");
            g.com(room);
            g.view(room);
            draw++;
        }
        while (true) {
            System.out.println("\n플레이어의 턴입니다.");
            if (!g.ipCheck(sc.nextInt(), room)) {
                System.out.println("다시 입력하세요.");
                continue;
            }
            g.view(room);
            draw++;
            if (result(g, room, draw)) break;

            System.out.println("\n컴퓨터의 턴입니다.");
            g.com(room);
            g.view(room);
            draw++;
            if (result(g, room, draw)) break;
        }
        System.out.println("게임을 종료합니다.");
        sc.close();
    }

    public static boolean result(Game g, int[][] room, int draw) {
        if (g.result(room) == 2) {
            System.out.println("\n\n컴퓨터의 승리입니다");
            return true;
        } else if (g.result(room) == 1) {
            System.out.println("\n\n플레이어의 승리입니다");
            return true;
        } else if (draw == 9) {
            System.out.println("무승부입니다.");
            return true;
        } else return false;
    }

}

//TTT main code