package inter;

public interface Printable {
    /* public static final */int HEIGHT = 70;
    int WIDTH = 120;

    /* public */ void print(String mydoc);

    default void clean(){
        System.out.println("청소기능 추가");
    }

    static void printLine(){
        System.out.println("줄바꿈");
    }

}