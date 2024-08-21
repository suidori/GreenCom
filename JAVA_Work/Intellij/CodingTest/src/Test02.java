import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] board = new char[N][M];

        for(int i = 0; i<N; i++){
            board[i] = sc.next().toCharArray();
        }

        int result = 64;

        for(int i = 0; i<M-8; i++){
            for(int j = 0; j<N-8; j++){
                int count = 0;
                char[][] chess = new char[8][8];
                for(int k = 0; k<8; k++){
                    chess[k] = Arrays.copyOf(board[j], i);
                }
            }
        }

    }
}
