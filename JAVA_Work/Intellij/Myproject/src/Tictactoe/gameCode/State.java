package Tictactoe.gameCode;

public class State {
    int win = 0;
    int draw = 0;
    int lose = 0;
    public void printResult(){
        System.out.printf("최종 스코어 : [ %d승, %d무, %d패 ]", win, draw, lose); //result 참조하여 승 무 패 출력
    }

    public void addWin(){
        win++;
    }
    public void addDraw(){
        draw++;
    }
    public void addLose(){
        lose++;
    }
    public boolean count(Game g, int draw) {
        if (g.result() == 2) { //컴퓨터의 승리 조건
            System.out.println("\n\n컴퓨터의 승리입니다");
            addLose(); //패배 카운트
            return true;
        } else if (g.result() == 1) { //플레이어의 승리 조건
            System.out.println("\n\n플레이어의 승리입니다");
            addWin(); //승리 카운트
            return true;
        } else if (draw == 9) { //무승부 조건
            System.out.println("무승부입니다.");
            addDraw(); //무승무 카운트
            return true;
        } else return false; //승리 조건 없을 시 return false
    }

}
