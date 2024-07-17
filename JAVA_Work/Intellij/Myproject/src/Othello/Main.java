package Othello;
import Othello.gameCode.*;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Play p = new Play();
            ResultCount resultCount = new ResultCount();
            TypeCheck input = new TypeCheck();

            ///시작
            System.out.println("오셀로 게임을 시작합니다.");
            System.out.println("게임의 설명을 들으시겠습니까? (y/n)");
            input.rule(sc);

            //플레이

            while (input.replay) {
                p.play(sc); //게임플레이
                System.out.println("다시 플레이하시겠습니까? (y/n)");
                input.doReplay(sc);
            }

            //종료

            System.out.println("게임이 종료되었습니다.");
            resultCount.printResult();
            sc.close();
        }
    }