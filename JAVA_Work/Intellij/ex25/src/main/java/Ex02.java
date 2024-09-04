public class Ex02 {
    public static void main(String[] args) {
        Runnable run1 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread th1 = new Thread(run1);
        th1.start();

        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
