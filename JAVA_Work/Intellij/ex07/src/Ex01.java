import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {

        int num[][] = new int[4][3];

        int a = 0;

        for(int i = 0; i<4; i++){
            for (int j = 0; j < 3; j++) {
                num[i][j] = a++;
            }
        }
        System.out.println(a);
        System.out.println(Arrays.toString(num[0]));
    }
}
