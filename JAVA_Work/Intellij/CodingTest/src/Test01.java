import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = new String("1234");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

    }

}
