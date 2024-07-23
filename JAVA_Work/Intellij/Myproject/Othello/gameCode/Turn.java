package Othello.gameCode;

import java.util.Scanner;

public class Turn {

    public void comTurn(int[][] room, int[] list, Flip flip) {
        int comInput = (int) (Math.random() * list.length); //놓을 수 있는 공간 중 랜덤한 공간 선택
        int k = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (list[comInput] == (i + j + k)) { //선택된 공간을 찾으면
                    System.out.println("컴퓨터가 " + list[comInput] + "에 말을 놓았습니다.");
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

    public void playerTurn(int[][] room, int[] list, Scanner sc, Flip flip) {

        int playerInput;
        try{
            playerInput = sc.nextInt();
        }
        catch(Exception e){
            System.out.println("숫자만 입력 해 주십시오");
            sc.nextLine();
            playerTurn(room, list, sc, flip);
            return;
        }

//        String str = sc.nextLine();
//        if (!str.replaceAll("[0-9]", "").isEmpty()){//문자가 포함될 경우
//            System.out.println("숫자만 입력 해 주세요.");
//            playerTurn(room, list, sc, flip);//재귀
//            return;
//        }
//        if (str.isEmpty()) {//빈 문자열 입력 시
//            playerTurn(room, list, sc, flip);//재귀
//            return;
//        }
//
//        int playerInput = Integer.parseInt(str); //입력받은 내용을 int로 변환

        int k = 1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == playerInput) { //놓을 수 있는 공간 list에 플레이어가 입력한 숫자가 있다면
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
        System.out.println("올바른 숫자를 입력 해 주세요.");
        playerTurn(room, list, sc, flip); //재귀
    }

}

