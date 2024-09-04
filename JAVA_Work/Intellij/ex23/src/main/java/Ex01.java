import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list = new ArrayList<>(list);

        list.stream()
                .forEach(System.out::println);

        int result = list.stream()
                .mapToInt(num->num)
                .sum();

//        System.out.println(result);

        result = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(result);

        result = list.stream()
                .filter(value->value%2==0)
                .reduce(0, Integer::sum);

        System.out.println(result);

        result = list.stream()
                .filter(value->value%2==1)
                .reduce(0, Integer::sum);

        System.out.println(result);

    }
}
