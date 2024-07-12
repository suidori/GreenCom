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

}
