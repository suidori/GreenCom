import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        Person[] parr = {
                new Person("dddd", 40),
                new Person("a", 20),
                new Person("bb", 30),
                new Person("ccc", 40)
        };
        Arrays.sort(parr);

        System.out.println(Arrays.toString(parr));
    }
}
