package GameCode;

import java.util.Arrays;
import java.util.Scanner;

public class PutScore {
    int aces, deuces, threes, fours, fives, sixes;
    int choice, foak, fh, ss, ls, yc;
    public int[] total = new int[3];
    public int[] bonus = new int[3];
    boolean[][] blank = new boolean[16][3];


    private void upCount(int[] dice) {
        aces = 0;
        deuces = 0;
        threes = 0;
        fours = 0;
        fives = 0;
        sixes = 0;

        for (int i = 0; i < 5; i++) {
            if (1 == dice[i]) aces++;
            if (2 == dice[i]) deuces++;
            if (3 == dice[i]) threes++;
            if (4 == dice[i]) fours++;
            if (5 == dice[i]) fives++;
            if (6 == dice[i]) sixes++;
        }
    }

    private void downCount(int[] dice) {
        choice = 0;
        for (int i = 0; i < 5; i++) {
            choice += dice[i];
        }
        foak = 0;
        if (dice[1] == dice[3] && ((dice[0] == dice[1]) || (dice[3] == dice[4]))) {
            foak = choice;
        }
        fh = 0;
        if (dice[0] == dice[1] && dice[3] == dice[4]) {
            if (dice[1] == dice[2] || dice[2] == dice[3]) {
                fh = choice;
            }
        }
        ss = 0;
        if (dice[1] + 1 == dice[2] && dice[2] + 1 == dice[3]) {
            if (dice[0] + 1 == dice[1] || dice[3] + 1 == dice[4]) {
                ss = 15;
            }
        }
        ls = 0;
        if (Arrays.equals(dice, new int[]{1, 2, 3, 4, 5}) || Arrays.equals(dice, new int[]{2, 3, 4, 5, 6})) {
            ls = 30;
        }


        yc = 50;
        for (int i = 1; i < dice.length; i++) {
            if (dice[i] != dice[0]) {
                yc = 0;
            }
        }
    }


    public void putScore(String[][] board, int[] dice, Scanner sc, int player) {
        upCount(dice);
        downCount(dice);
        System.out.println("원하는 Categories의 번호를 입력 해 주십시오.");
        String input = sc.nextLine();

        if(input.isEmpty()){
            putScore(board, dice, sc, player);
            return;
        }

        if(!input.replaceAll( "[0-9]", "").isEmpty()){
            System.out.println("숫자만 입력 해 주세요");
            putScore(board, dice, sc, player);
            return;
        }

        switch (Integer.parseInt(input)) {
            case (1):
                if (!blank[1][player]) {
                    blank[1][player] = true;
                    board[1][player] = String.format("      %d      ", aces);
                    total[player] += aces;
                    bonus[player] += aces;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (2):
                if (!blank[2][player]) {
                    blank[2][player] = true;
                    board[2][player] = String.format("      %d      ", 2 * deuces);
                    total[player] += 2 * deuces;
                    bonus[player] += 2 * deuces;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (3):
                if (!blank[3][player]) {
                    blank[3][player] = true;
                    board[3][player] = String.format("      %d      ", 3 * threes);
                    total[player] += 3 * threes;
                    bonus[player] += 3 * threes;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (4):
                if (!blank[4][player]) {
                    blank[4][player] = true;
                    board[4][player] = String.format("      %d      ", 4 * fours);
                    total[player] += 4 * fours;
                    bonus[player] += 4 * fours;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (5):
                if (!blank[5][player]) {
                    blank[5][player] = true;
                    board[5][player] = String.format("      %d      ", 5 * fives);
                    total[player] += 5 * fives;
                    bonus[player] += 5 * fives;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (6):
                if (!blank[6][player]) {
                    blank[6][player] = true;
                    board[6][player] = String.format("      %d      ", 6 * sixes);
                    total[player] += 6 * sixes;
                    bonus[player] += 6 * sixes;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }

            case (7):
                if (!blank[9][player]) {
                    blank[9][player] = true;
                    board[9][player] = String.format("      %d      ", choice);
                    total[player] += choice;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (8):
                if (!blank[10][player]) {
                    blank[10][player] = true;
                    board[10][player] = String.format("      %d      ", foak);
                    total[player] += foak;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (9):
                if (!blank[11][player]) {
                    blank[11][player] = true;
                    board[11][player] = String.format("      %d      ", fh);
                    total[player] += fh;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (10):
                if (!blank[12][player]) {
                    blank[12][player] = true;
                    board[12][player] = String.format("      %d      ", ss);
                    total[player] += ss;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (11):
                if (!blank[13][player]) {
                    blank[13][player] = true;
                    board[13][player] = String.format("      %d      ", ls);
                    total[player] += ls;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            case (12):
                if (!blank[14][player]) {
                    blank[14][player] = true;
                    board[14][player] = String.format("      %d      ", yc);
                    total[player] += yc;
                    break;
                } else {
                    putScore(board, dice, sc, player);
                    break;
                }
            default:
                putScore(board, dice, sc, player);
                break;
        }
        board[7][1] = String.format("     %d/63 ", bonus[1]);
        board[7][2] = String.format("     %d/63 ", bonus[2]);
        board[8][1] = (bonus[1] > 63) ? "      35     " : "              ";
        board[8][2] = (bonus[2] > 63) ? "      35     " : "              ";
        board[15][1] = (bonus[1] > 63) ? String.format("      %d     ", total[1] + 35) : String.format("      %d     ", total[1]);
        board[15][2] = (bonus[2] > 63) ? String.format("      %d     ", total[2] + 35) : String.format("      %d     ", total[2]);

    }

}
