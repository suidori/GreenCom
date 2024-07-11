package Tictactoe;

public class Game {

    public boolean start(){
       return (((int)(Math.random()*2)==0));
            }

    public void view(int[][] room) {
        char player = 'O';
        char com = 'X';
        int k = 1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                String blank = "" + (i + j + k);
                if (room[i][j] == 1) {
                    System.out.print(player);
                } else if (room[i][j] == 2) {
                    System.out.print(com);
                } else {
                    System.out.print(blank);
                }
                if (j == 2) break;
                System.out.print(" | ");
            }
            if (i == 2) break;
            System.out.println("\n==========");
            k += 2;
        }
        System.out.println(" ");
    }

    public void com(int[][] room) {
        int input = (int) (Math.random() * 9 + 1);
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input == (i + j + k)) {
                    if (room[i][j] == 0) {
                        room[i][j] = 2;
                    } else {
                        com(room);
                    }
                }
            }
            k += 2;
        }
    }

    public boolean ipcheck(int input, int[][] room) {
        if (input < 1 || input > 9) {
            return false;
        }
        int k = 1;
        for (int i = 0; ; i++) {
            for (int j = 0; j < 3; j++) {
                if (input == (i + j + k)) {
                    if (room[i][j] == 0) {
                        room[i][j] = 1;
                        return true;
                    } else return false;
                }
            }
            k += 2;
        }
    }

    public int result(int[][] room) {
        for (int i = 0; i < 3; i++) {
            if((room[0][i]==room[1][i])&&(room[1][i]==room[2][i])&&(room[0][i] != 0 ))
                return room[i][0];
            if((room[i][0]==room[i][1])&&(room[i][1]==room[i][2])&&(room[i][0] != 0 ))
                return room[0][i];
        }
        if ((room[0][0] == room[1][1]) && (room[2][2] == room[1][1]) && (room[0][0]!=0))
            return room[0][0];
        else if ((room[2][0] == room[1][1]) && (room[0][2] == room[1][1]) && (room[0][2]!=0))
            return room[0][2];

        return -1;
    }

}