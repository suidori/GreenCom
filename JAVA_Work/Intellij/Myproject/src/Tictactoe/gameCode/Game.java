package Tictactoe.gameCode;

public class Game {

    int[][] room = new int[3][3]; //2차원 배열 선언(3*3 틱택토 그리드)
    int draw = 0; //무승부 카운트를 위한 변수 선언

    public boolean start() { //랜덤 함수 통해 50% 확률로 true 나 false 출력
        return (((int) (Math.random() * 2) == 0));
    }

    public void view() { //게임 진행 상황 출력 함수
        char player = 'O'; //플레이어의 기호
        char com = 'X'; //컴퓨터의 기호
        int k = 1; //숫자 출력을 위한 변수
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                String blank = "" + (i + j + k); //i+j+k = 1,2,3 -> 4,5,6 -> 7,8,9 를 출력함
                if (room[i][j] == 1) { //room이 1(플레이어의 칸)이라면
                    System.out.print(player);//O를 출력
                } else if (room[i][j] == 2) {//room이 2(컴퓨터의 칸) 이라면
                    System.out.print(com);//X를 출력
                } else {//둘 다 아니면(기본값이라면)
                    System.out.print(blank);//숫자 출력
                }
                if (j == 2) break; //마지막 줄에는 세로선 출력하지 않음
                System.out.print(" | "); //기호나 숫자 중간에 세로선 설치
            }
            if (i == 2) break; //마지막 줄에는 가로선 출력하지 않음
            System.out.println("\n=========="); //기호를 3번 출력할 때 마다 가로선 출력
            k += 2; //2개씩 뛰어넘음(1,2,3 다음에 4,5,6이 옴)
        }
        System.out.println(" ");
    }

    public void com() { //랜덤한 칸을 컴퓨터의 칸으로 만드는 함수
        int input = (int) (Math.random() * 9 + 1); //1~9 사이의 랜덤한 수 출력
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input == (i + j + k)) { //출력된 수와 같은 자리를 찾아서
                    if (room[i][j] == 0) {//빈칸이라면
                        room[i][j] = 2;//컴퓨터의 칸으로 만든다
                    } else {//빈칸이 아니라면
                        com();//다시 시도한다
                    }
                }
            }
            k += 2;
        }
    }

    public boolean ipCheck(int input) { //플레이어의 값을 입력받는 함수
        if (input < 1 || input > 9) { //1~9의 숫자가 아니라면
            return false; //잘못된 값이라는 결과 출력
        }
        int k = 1;
        for (int i = 0; ; i++) {
            for (int j = 0; j < 3; j++) {
                if (input == (i + j + k)) { //입력받은 값과 같은 자리를 찾아서
                    if (room[i][j] == 0) { // 빈칸이라면
                        room[i][j] = 1; // 플레이어의 칸으로 만듬
                        return true; //옳은 값을 입력함
                    } else return false; // 빈칸이 아니라면 틀린 값을 입력한것임
                }
            }
            k += 2;//2칸씩 뛰어넘음
        }
    }

    public void comTurn() {//room과 draw를 입력받음
        System.out.println("\n컴퓨터의 턴입니다.");
        com(); //컴퓨터의 칸 채우기 진행
        view(); // 결과 출력
        draw++; // 무승부 카운트 올림
    }

    public boolean playerTurn(int input) { //comTurn과 비슷하지만 숫자를 추가로 입력받음
        if (!ipCheck(input)) { //틀린 값을 입력했다면
            System.out.println("다시 입력하세요."); //경고문 출력 후
            return false; //false
        }
        view(); //옳은 값이라면 결과 출력
        draw++; //무승부 카운트 올림
        return true;
    }

    public int result() {
        for (int i = 0; i < 3; i++) {
            if ((room[0][i] == room[1][i]) && (room[1][i] == room[2][i]) && (room[0][i] != 0))//세로 3개가 같은 값이고, 0이 아니면
                return room[0][i]; // 그 값을 반환한다
            if ((room[i][0] == room[i][1]) && (room[i][1] == room[i][2]) && (room[i][0] != 0)) // 가로 3개가 같은 값이고, 0이 아니면
                return room[i][0]; // 그 값을 반환한다
        }
        if ((room[0][0] == room[1][1]) && (room[2][2] == room[1][1]) && (room[0][0] != 0)) // 대각선 3개가 같은 값이고, 0이 아니면
            return room[0][0]; // 그 값을 반환한다
        else if ((room[2][0] == room[1][1]) && (room[0][2] == room[1][1]) && (room[0][2] != 0))
            return room[0][2]; //대각선 반환 2

        return -1; //모두 아니라면 없는 값을 반환한다.
    }

    public boolean result(State state) {
        if (result() == 2) { //컴퓨터의 승리 조건
            System.out.println("\n\n컴퓨터의 승리입니다");
            state.addLose(); //state[2] = 패배 카운트
            return true;
        } else if (result() == 1) { //플레이어의 승리 조건
            System.out.println("\n\n플레이어의 승리입니다");
            state.addWin(); //state[1] = 승리 카운트
            return true;
        } else if (draw == 9) { //무승부 조건
            System.out.println("무승부입니다.");
            state.addDraw(); //state[0] = 무승무 카운트
            return true;
        } else return false; //승리 조건 없을 시 return false
    }

}

//Play gameplay code