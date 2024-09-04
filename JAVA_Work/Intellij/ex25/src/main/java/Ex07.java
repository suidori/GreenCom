import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex07 {

    public static List<Integer> list =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        System.out.println(list);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            ListIterator<Integer> itr = list.listIterator();
            while(itr.hasNext()){
                itr.set(itr.next()+1);
            }
        });
        executorService.submit(()->{
            ListIterator<Integer> itr = list.listIterator();
            while(itr.hasNext()){
                itr.set(itr.next()+1);
            }
        });
        executorService.submit(()->{
            ListIterator<Integer> itr = list.listIterator();
            while(itr.hasNext()){
                itr.set(itr.next()+1);
            }
        });


        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(list);
    }
}
