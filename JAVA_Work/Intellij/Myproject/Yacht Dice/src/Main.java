import GameCode.*;

public class Main {
    public static void main(String[] args) {
        Turn turn = new Turn();
        PutScore ps = new PutScore();
        ScoreBoard sb = new ScoreBoard();

        sb.printBoard();

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
