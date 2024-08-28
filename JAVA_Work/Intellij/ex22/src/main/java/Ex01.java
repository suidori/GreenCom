import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Ex01 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,3,5,7,9);
        list = new ArrayList<>(list);

        System.out.println(list);

        Consumer<List<Integer>> consumer = Collections::reverse;
        consumer.accept(list);

        System.out.println(list);

    }
}
