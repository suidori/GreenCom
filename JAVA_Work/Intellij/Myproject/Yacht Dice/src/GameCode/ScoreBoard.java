package GameCode;

public class ScoreBoard {
    String[][] board = new String[16][3];

    public ScoreBoard() {
        board[0] = new String[]{"Categories        |", " Player 1 ", " Player 2 "};
        board[1][0] = "01. Aces           |";
        board[2][0] = "02. Deuces       |";
        board[3][0] = "03. Threes       |";
        board[4][0] = "04. Fours         |";
        board[5][0] = "05. Fives          |";
        board[6][0] = "06. Sixes         |";
        board[7] = new String[]{"Subtotal          |", "      0/63 ", "     0/63 "};
        board[8][0] = "       +35 Bonus |";
        board[9][0] = "07. Choice        |";
        board[10][0]= "08. 4 of a Kind |";
        board[11][0]= "09. Full House   |";
        board[12][0]= "10. S. Straight  |";
        board[13][0]= "11. L. Straight  |";
        board[14][0]= "12. Yacht         |";
        board[15] = new String[]{"Total               |", "       0     ", "       0     "};

        for (int i = 1; i < 15; i++) {
            if(board[i][1]==null){board[i][1]="              ";}
            if(board[i][2]==null){board[i][2]="              ";}
        }

    }
    public void printBoard(){
        System.out.println("=====================================");
        for (int i = 0; i < 9; i++) {
            System.out.printf("[ %s%s|%s ]\n", board[i][0], board[i][1], board[i][2]);
        }
        System.out.println("=====================================");
        System.out.println("Bonus if Aces~Sixes are over 63 points");
        System.out.println("=====================================");
        for (int i =9; i<16; i++){
            System.out.printf("[ %s%s|%s ]\n", board[i][0], board[i][1], board[i][2]);
        }
        System.out.println("=====================================");
    }

}
