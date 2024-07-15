package Tictactoe.gameCode;

import java.util.Scanner;

public class Input {
    public boolean replay = true;

    public static void rule(Scanner sc) {
        String input = sc.next();
        if (input.equals("y")) {
            System.out.println("1. 당신은 가상의 상대와 대결하게 됩니다.");
            System.out.println("2. 3X3 모양의 공간이 주어집니다.");
            System.out.println("3. 서로 돌아가면서 자신의 기호로 칸을 채웁니다.");
            System.out.println("4. 가로,세로,대각선 중 한 줄을 먼저 채운 사람이 승리합니다.");
            System.out.println("5. 당신의 기호는 'O' 이고, 상대의 기호는 'X' 입니다.");
            System.out.println("6. 1~9에 해당하는 숫자를 입력해서 칸을 채웁니다.\n");
            return;
        } else if (input.equals("n")) {
            return;
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            rule(sc);
        }
    }

    public void doReplay(Scanner sc) {
        String input = sc.next();
        if (input.equals("y")) {
            replay = true;
            return;
        } else if (input.equals("n")) {
            replay = false;
            return;
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            doReplay(sc);
        }
    }
}
