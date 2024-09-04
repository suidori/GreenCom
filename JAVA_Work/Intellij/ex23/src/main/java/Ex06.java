import java.util.stream.Stream;

public class Ex06 {
    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);

//        boolean b = integerStream
//                .allMatch(num->num%2==0);
//
//        System.out.println(b);

        integerStream
                .filter(num->num%2==0)
                .forEach(System.out::println);

    }
}
