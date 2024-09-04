class Task extends Thread{
    @Override
    public void run() {
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

public class Ex03 {
    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();

        task1.start();
        task2.start();

        Thread task3 = new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
