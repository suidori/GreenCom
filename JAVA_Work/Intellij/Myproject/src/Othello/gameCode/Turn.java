package Othello.gameCode;

import java.util.ArrayList;
import java.util.Scanner;

public class Turn {

    public void comTurn(int[][] room, ArrayList<Integer> list, Flip flip) {
        int comInput = (int) (Math.random() * list.size());
        int k = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list.get(comInput) == (i + j + k)) {
                    System.out.println(list.get(comInput));
                    room[i][j] = 2;
                    flip.doFlip(room, i, j,2);
                    return;
                }
            }
            k += 7;
        }
    }

    public void playerTurn(int[][] room, ArrayList<Integer> list, Scanner sc, Flip flip) {

        String str = sc.nextLine();
        if (str.length() > 2) {
            System.out.println("숫자만 입력 해 주세요.");
            playerTurn(room, list, sc, flip);
            return;
        }
        if(str.length()==2 && str.charAt(1)<'0' && str.charAt(1)>'9'){
            System.out.println("숫자만 입력 해 주세요.");
            playerTurn(room, list, sc, flip);
            return;
        }
        if (str.isEmpty()) {
            playerTurn(room, list, sc, flip);
            return;
        }

        int playerInput = Integer.parseInt(str);

        int k = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == playerInput) {
                for (int j = 0; j < 8; j++) {
                    for (int l = 0; l < 8; l++) {
                        if (playerInput == j + l + k) {
                            room[j][l] = 1;
                            flip.doFlip(room, j, l, 1);
                            return;
                        }
                    }
                    k += 7;
                }
            }
        }
        System.out.println("올바른 숫자를 입력 해 주세요.");
        playerTurn(room, list, sc, flip);
    }

}

