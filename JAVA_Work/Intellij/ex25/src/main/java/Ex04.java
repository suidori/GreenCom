class Counter{
    private int count = 0;
    public void increment(){
        count++;
    }
    public void decrement(){
        count--;
    }
    public int getCount(){
        return count;
    }
}

public class Ex04 {

    public static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable run1 = () ->{
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Runnable run2 = () ->{
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        };

        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println(counter.getCount());


    }
}
