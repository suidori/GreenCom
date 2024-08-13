class MyBox<T>{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

public class Ex04 {
    public static void main(String[] args) {
        MyBox<Integer> mybox1 = new MyBox<>();
        MyBox<String> mybox2 = new MyBox<>();
    }
}
