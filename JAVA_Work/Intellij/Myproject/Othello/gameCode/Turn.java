package Othello.gameCode;

import java.util.ArrayList;
import java.util.Scanner;

public class Turn {

    public void comTurn(int[][] room, ArrayList<Integer> list, Flip flip) {
        int comInput = (int) (Math.random() * list.size()); //놓을 수 있는 공간 중 랜덤한 공간 선택
        int k = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list.get(comInput) == (i + j + k)) { //선택된 공간을 찾으면
                    System.out.println("컴퓨터가 " + list.get(comInput) + "에 말을 놓았습니다.");
                    //말을 놓음
                    room[i][j] = 2;
                    //뒤집기 수행
                    flip.doFlip(room, i, j,2);
                    return;
                }
            }
            k += 7;
        }
    }

    public void playerTurn(int[][] room, ArrayList<Integer> list, Scanner sc, Flip flip) {

        String str = sc.nextLine();
        if (str.length() > 2) { //2자리가 넘어가는 숫자를 입력 시
            System.out.println("최대 2자리, 숫자만 입력할 수 있습니다.");
            playerTurn(room, list, sc, flip);//재귀
            return;
        }
        if(str.length()==2 && str.charAt(1)<'0' && str.charAt(1)>'9'){ //숫자가 아닌 문자가 있다면
            System.out.println("최대 2자리, 숫자만 입력할 수 있습니다.");
            playerTurn(room, list, sc, flip);//재귀
            return;
        }
        if (str.isEmpty()) {//빈 문자열 입력 시
            playerTurn(room, list, sc, flip);//재귀
            return;
        }

        int playerInput = Integer.parseInt(str); //입력받은 내용을 int로 변환

        int k = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == playerInput) { //놓을 수 있는 공간 list에 플레이어가 입력한 숫자가 있다면
                for (int j = 0; j < 8; j++) {
                    for (int l = 0; l < 8; l++) {
                        if (playerInput == j + l + k) { //그 공간을 찾아서
                            room[j][l] = 1; //플레이어의 말을 놓음
                            flip.doFlip(room, j, l, 1); //뒤집음
                            return;
                        }
                    }
                    k += 7;
                }
            }
        }
        //list에 플레이어가 입력한 숫자가 없다면 틀린 숫자이므로
        System.out.println("올바른 위치를 입력 해 주세요.");
        playerTurn(room, list, sc, flip); //재귀
    }

}

