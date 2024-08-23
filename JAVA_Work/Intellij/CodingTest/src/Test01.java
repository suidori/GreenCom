import java.util.Scanner;

public class Test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long V = sc.nextLong();

        long count = (V / (A-B)) - B;
        long up = (count)*(A-B);

        while(true){
            count++;
            up += A;
            if(up>=V){break;}
            up -= B;
        }

        System.out.println(count);
    }
}
