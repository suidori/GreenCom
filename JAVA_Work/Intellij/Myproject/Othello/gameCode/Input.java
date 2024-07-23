package Othello.gameCode;

import java.util.Scanner;

public class Input {
    public boolean replay = true;
    private boolean gameMode;

    public void inputCheck(Scanner sc) {
        String input = sc.nextLine();
        if (input.isEmpty()) {
            inputCheck(sc);
        }

        if (input.charAt(0) == 'y') {
            if (!gameMode) {
                System.out.println("1. 당신은 가상의 상대와 대결하게 됩니다.");
                System.out.println("2. 8X8 크기의 공간이 주어집니다.");
                System.out.println("3. 서로 돌아가면서 말을 놓습니다.");
                System.out.println("자신의 말이 상대방의 말을 감싸는 형태가 될 때에만 말을 놓을 수 있습니다.");
                System.out.println("놓을 수 있는 칸은 숫자로 표기됩니다.");
                System.out.println("4. 말을 놓을 때 감싸진 상대방의 말은 자신의 말로 변합니다.");
                System.out.println("5. 당신의 말은 'O' 이고, 상대의 말은 'X' 입니다.");
                System.out.println("6. 원하는 칸에 해당하는 숫자를 입력해서 말을 놓습니다. \n");
                gameMode = true;
            } else replay = true;
        } else if (input.charAt(0) == 'n') {
            if (!gameMode) {
                System.out.println("설명을 듣지 않습니다.\n");
                gameMode = true;
            } else replay = false;
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            inputCheck(sc);
        }
    }
}