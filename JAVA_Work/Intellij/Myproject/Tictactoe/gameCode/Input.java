package Tictactoe.gameCode;

import java.util.Scanner;

public class Input {
    public boolean replay = true;

    public void rule(Scanner sc) {
        String input = sc.nextLine();
        if(input.isEmpty()){
            rule(sc);
        }
        if (input.charAt(0)=='y') {
            System.out.println("1. 당신은 가상의 상대와 대결하게 됩니다.");
            System.out.println("2. 3X3 모양의 공간이 주어집니다.");
            System.out.println("3. 서로 돌아가면서 자신의 기호로 칸을 채웁니다.");
            System.out.println("4. 가로,세로,대각선 중 한 줄을 먼저 채운 사람이 승리합니다.");
            System.out.println("5. 당신의 기호는 'O' 이고, 상대의 기호는 'X' 입니다.");
            System.out.println("6. 빈 칸에 해당하는 숫자를 입력해서 칸을 채웁니다.\n");
        } else if (input.charAt(0)=='n') {
            System.out.println("설명을 듣지 않습니다.\n");
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            rule(sc);
        }
    }

    public void doReplay(Scanner sc) {
        String input = sc.nextLine();
        if(input.isEmpty()){
            rule(sc);
        }
        if (input.charAt(0)=='y') {
            replay = true;
        } else if (input.charAt(0)=='n') {
            replay = false;
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            doReplay(sc);
        }
    }
}
