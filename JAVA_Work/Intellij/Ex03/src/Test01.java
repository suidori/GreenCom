/*
가위 바위 보 게임을 만들어 보자.
사용자로부터 가위 바위 보 중에서 하나를 입력 받는다.
그리고 컴퓨터는 난수 생성을 통해서 가위 바위 보 중에서 하나를 선택하게 한다.
이 둘을 비교해서 승자와 패자를 가려주는 프로그램을 작성해 보자.
단, 프로그램의 진행은 사용자가 질 때까지 계속되어야 하고,
마지막에 가서는 게임의 결과까지 출력해 주도록 하자.
 */

import java.util.Scanner;

class RO {
    public static String computer() {
        int random = (int) (Math.random() * 3);
        String output = "";
        switch (random) {
            case 0:
                output = "가위";
                break;
            case 1:
                output = "바위";
                break;
            case 2:
                output = "보";
                break;
            default:
                break;
        }
        return output;
    }
}

public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int win = 0;
        int draw = 0;

        while (true) {
            System.out.println("가위 바위 보 중에 하나를 입력하세요.");
            String player = input.next();
            String computer = RO.computer();

            if (!start(player, computer)) {
                continue;
            }
            if (game(player, computer) == 1) {
                System.out.println("이겼습니다.");
                win++;
            } else if (game(player, computer) == 0) {
                System.out.println("무승부입니다.");
                draw++;
            } else {
                break;
            }
        }
        System.out.println("패배했습니다. 게임이 종료됩니다.");
        System.out.println("결과: " + win + "승 " + draw + "무 1패");
    }

    public static boolean start(String player, String computer) {
        if (player.equals("가위") || player.equals("바위") || player.equals("보")) {
            System.out.println("당신은 " + player + "를 냈습니다.");
            System.out.println("상대방은 " + computer + "를 냈습니다.");
            return true;
        } else {
            System.out.println("정확하게 입력해 주십시오.");
            return false;
        }
    }

    public static int game(String player, String computer) {
        if (player.equals(computer)) {
            return 0;
        } else if ((player.equals("가위") && computer.equals("보"))
                || (player.equals("바위") && computer.equals("가위"))
                || (player.equals("보") && computer.equals("바위"))) {
            return 1;
        } else {
            return 2;
        }
    }
}