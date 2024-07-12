package Tictactoe.gameCode;

import java.util.Scanner;

public class Play {
    public static void play(int[] result) {
        System.out.println("게임을 시작합니다.");
        Game g = new Game();
        int[][] room = new int[3][3];
        g.view(room);
        Scanner sc = new Scanner(System.in);
        int[] draw = new int[1];

        if (g.start()) {
            System.out.println("선공입니다.");
        } else {
            System.out.println("후공입니다.");
            g.comTurn(room, draw);
        }
        while (true) {
            System.out.println("\n플레이어의 턴입니다.");
            if (!g.playerTurn(sc.nextInt(), room, draw)) continue;
            if (result(g, room, draw, result)) break;

            g.comTurn(room, draw);
            if (result(g, room, draw, result)) break;
        }
        sc.close();
    }

    public static boolean result(Game g, int[][] room, int[] draw, int[] result) {
        if (g.result(room) == 2) {
            System.out.println("\n\n컴퓨터의 승리입니다");
            result[2]++;
            return true;
        } else if (g.result(room) == 1) {
            System.out.println("\n\n플레이어의 승리입니다");
            result[1]++;
            return true;
        } else if (draw[0] == 9) {
            System.out.println("무승부입니다.");
            result[0]++;
            return true;
        } else return false;
    }


}

//Play play code