import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex05 {
    public static void main(String[] args) {
        Runnable run1 = () -> {
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName()+ " " + (n1+n2));
        };

        ExecutorService exr = Executors.newSingleThreadExecutor();
        exr.submit(run1);
        System.out.println("end" + Thread.currentThread().getName());
        exr.shutdown();

    }
}
