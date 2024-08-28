import java.util.function.Function;

public class Ex04 {
    public static void main(String[] args) {
        Function<char[], String> function = String::new;

        String test = function.apply(new char[]{'a','b','c','d'});
        System.out.println(test);
    }

}
