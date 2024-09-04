public class Ex01 {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 1000; i++) {
            Thread th1 = Thread.currentThread();
            System.out.println(th1.getName() + " " + i);
        }

    }
}
