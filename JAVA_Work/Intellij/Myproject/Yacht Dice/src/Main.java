import GameCode.*;

public class Main {
    public static void main(String[] args) {
        Turn turn = new Turn();
        PutScore ps = new PutScore();
        ScoreBoard sb = new ScoreBoard();

        sb.printBoard();

        System.out.println("※굴려진 주사위 값을 저장하려면 원하는 숫자를 입력하세요.");
        System.out.println("※저장된 주사위 값을 제거하려면 원하는 숫자를 음수로 입력하세요.");
        System.out.println("※0을 입력하면 다음 주사위 굴림으로 넘어갑니다.");

        for (int i = 0; i < 12; i++) {
            turn.playerTurn(sb, ps, 1);
            sb.printBoard();
            turn.playerTurn(sb, ps, 2);
            sb.printBoard();
        }
        count(ps.total[1], ps.total[2], ps);
    }

    private static int result(int p1, int p2, PutScore ps){
        p1 = (ps.bonus[1] > 63) ? p1+35 : p1;
        p2 = (ps.bonus[2] > 63) ? p2+35 : p2;

        if(p1>p2) return 1;
        else if(p2>p1) return 2;
        else return 0;
    }

    private static void count(int p1, int p2, PutScore ps){
        if(result(p1, p2, ps)==1){
            System.out.println("플레이어 1의 승리입니다!");
        } else if (result(p1, p2, ps)==2) {
            System.out.println("플레이어 2의 승리입니다!");
        } else System.out.println("무승부입니다!");
    }

}
