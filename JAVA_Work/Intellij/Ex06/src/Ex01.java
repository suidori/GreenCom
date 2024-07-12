import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {

        int ar[] = new int[5];

        Arrays.fill(ar, 3);

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

    }
}
