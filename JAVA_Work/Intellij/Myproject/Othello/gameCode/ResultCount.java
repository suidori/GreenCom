package Othello.gameCode;

public class ResultCount {
    int win = 0;
    int draw = 0;
    int lose = 0;

    public boolean doCount(CheckState check, int[][] room) {
        if (check.checkEnd(room) == 2) { //컴퓨터의 승리 조건
            System.out.println("\n\n컴퓨터의 승리입니다");
            lose++; //패배 카운트
            return true;
        } else if (check.checkEnd(room) == 1) { //플레이어의 승리 조건
            System.out.println("\n\n플레이어의 승리입니다");
            win++; //승리 카운트
            return true;
        } else if (check.checkEnd(room) == 3) { //무승부 조건
            System.out.println("무승부입니다.");
            this.draw++; //무승무 카운트
            return true;
        } else return false; //승리 조건 없을 시 return false
    }

    public void printResult(){
        System.out.printf("최종 스코어 : [ %d승, %d무, %d패 ]", win, draw, lose);
    }

}
