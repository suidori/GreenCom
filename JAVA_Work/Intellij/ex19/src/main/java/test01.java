import java.util.Arrays;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        char[] chars = N.toCharArray();
        long sum = 0;
        for(int i = 0; i<chars.length; i++){
            if(Character.isDigit(chars[i])){
                sum += chars[i]*Math.pow(B, chars.length-i-1);
            }else{
                sum += (chars[i] - 'A' + 10)*Math.pow(B, chars.length-i-1);
            }
        }
        System.out.println(sum);
    }
}
