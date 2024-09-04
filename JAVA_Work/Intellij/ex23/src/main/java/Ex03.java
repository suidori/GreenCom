import java.util.Arrays;
import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("MY_AGE", "YOUR_LIFE");

        stream1.flatMap(s -> Arrays.stream(s.split("_")))
                .forEach(System.out::println);
    }
}
