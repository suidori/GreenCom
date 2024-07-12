package Tictactoe.gameCode;

public class Input {
    public boolean replay = true;

    public static boolean rule(String input) {
        if (input.equals("y")) {
            System.out.println("1. 당신은 가상의 상대와 대결하게 됩니다.");
            System.out.println("2. 3X3 모양의 공간이 주어집니다.");
            System.out.println("3. 서로 돌아가면서 자신의 기호로 칸을 채웁니다.");
            System.out.println("4. 가로,세로,대각선 중 한 줄을 먼저 채운 사람이 승리합니다.");
            System.out.println("5. 당신의 기호는 'O' 이고, 상대의 기호는 'X' 입니다.");
            System.out.println("6. 1~9에 해당하는 숫자를 입력해서 칸을 채웁니다.\n");
            return false; //y를 입력함(break)
        } else if (input.equals("n")) {
            return false; //n을 입력함(break)
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            return true; //잘못된 값을 입력함
        }
    }

    public boolean replay(String input) {
        if (input.equals("y")) { //y 입력 시 재시작
            replay = true;
            return false;
        } else if (input.equals("n")) {
            replay = false;
            return false; // n 입력 시 종료
        } else {
            System.out.println("y나 n을 입력 해 주십시오.");
            return true; //잘못된 값을 입력함
        }
    }
}
