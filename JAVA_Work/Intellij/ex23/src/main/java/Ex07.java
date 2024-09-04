import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex07 {
    public static void main(String[] args) {
        List<Integer> oddlist = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(n->n%2==1)
                .collect(Collectors.toList());

        System.out.println(oddlist);

        Set<Integer> mset = Stream.of(10,10,10,20,30,40,50,50,30,60)
                .collect(Collectors.toSet());

        System.out.println(mset);

    }
}
