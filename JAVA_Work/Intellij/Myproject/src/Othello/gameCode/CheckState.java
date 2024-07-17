package Othello.gameCode;

public class CheckState {
    int player;
    int com;

    public int checkEnd(int[][] room) {
        player = 0;
        com = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (room[i][j] == 1) {
                    player++;
                } else if (room[i][j] == 2) {
                    com++;
                }
            }
        }
        if (player == 0) {
            return 2;
        } else if (com == 0) {
            return 1;
        } else if ((player + com) == 64) {
            if (player == com) {
                return 3;
            }
            return (player > com) ? 1 : 2;
        }
        return 0;
    }
}
