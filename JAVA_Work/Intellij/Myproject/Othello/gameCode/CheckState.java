package Othello.gameCode;

public class CheckState {
    int player;
    int com;

    public int checkEnd(int[][] room) {
        player = 0;
        com = 0;
        for (int i = 0; i < 8; i++) {
            for (int e:room[i]) {
                if (e == 1) { //player(백돌)의 갯수를 센다
                    player++;
                } else if (e == 2) { //com(흑돌)의 갯수를 센다
                    com++;
                }
            }
        }

        if (player == 0) { //백돌이 없으면
            return 2; //컴퓨터의 승리
        } else if (com == 0) { //흑돌이 없으면
            return 1; //플레이어의 승리
        } else if ((player + com) == 64) { //백돌과 흑돌의 합이 64일 때 (게임판이 꽉 찼을 때)
            if (player == com) { //백돌과 흑돌의 갯수가 같으면 무승부
                return 3;
            }
            return (player > com) ? 1 : 2; //무승부가 아니라면 더 많은 쪽의 승리
        }
        return 0; //승, 패, 무승부가 결정되지 않으면 계속 진행
    }
}
