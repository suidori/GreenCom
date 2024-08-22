import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex03 {
    public static void main(String[] args) {

        List<Car> list = Arrays.asList(
                new Car("그랜저", 3000),
                new Car("K8", 3500),
                new Car("쏘렌토", 2200)
        );

        System.out.println(list);

        for (Car car : list){
            System.out.println(car);
        }

        System.out.println(list.get(0));

        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getDisp() - o2.getDisp();
            }
        });

        System.out.println();
        for (Car car : list){
            System.out.println(car);
        }

    }
}
