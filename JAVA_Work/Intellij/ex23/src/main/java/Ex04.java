import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {
        Stream<Person> ss = Stream.of(
                new Person(100, 90, 80),
                new Person(90, 80, 70),
                new Person(60, 70, 80));

        IntStream is = ss
                .flatMapToInt( person ->
                        IntStream.of(person.getEng(),person.getKor(),person.getMath())
                );

        System.out.println("total =" + is.sum());
        System.out.println("avg =" + is.average().orElse(0));
    }
}
