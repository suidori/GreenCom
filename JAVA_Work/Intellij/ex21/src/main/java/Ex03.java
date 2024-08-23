import java.util.*;

public class Ex03 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("AA", "BBB", "DDDD", "Z", "");
        list=new ArrayList<>(list);

        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}
