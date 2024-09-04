import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        Stream.of(11,22,33,44,55)
                .forEach(System.out::println);

        Stream.of("So Simple", "So So", "11, 22, 33")
                .forEach(System.out::println);

        List<String> list = Arrays.asList("11", "22", "33");
        List<String> list2 = Arrays.asList("44", "55", "66");

        Stream.of(list, list2)
                .flatMapToInt(s->s.stream().mapToInt(Strings -> Integer.parseInt(Strings)))
                        .forEach(System.out::println);

        int result = list.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(result);


    }
}
