package Tictactoe;
import Tictactoe.gameCode.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mainScan = new Scanner(System.in);
        Input input = new Input();
        Count count = new Count();
        ///시작
        System.out.println("틱택토 게임을 시작합니다.");
        System.out.println("게임의 설명을 들으시겠습니까? (y/n)");
        Input.rule(mainScan);

        //플레이

        while (input.replay) {
            Play.play(count, mainScan); //게임플레이
            System.out.println("다시 플레이하시겠습니까? (y/n)");
            input.doReplay(mainScan);
        }

        //종료

        System.out.println("게임이 종료되었습니다.");
        count.printResult();
        mainScan.close();
    }

}

//Main code