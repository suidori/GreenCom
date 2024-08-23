interface AA{
    void doA();
    default void doB(){
        System.out.println("doB");
    }
    static void doC(){
        System.out.println("doC");
    }
}

public class Ex04 {

    public static void doA(int a){
        System.out.println(a);
    }

    public static void doMethod(AA aa){
        aa.doA();
    }

    public static void main(String[] args) {
        AA aa = ()->{
            System.out.println("doA");
        };

        aa.doA();
        aa.doB();
        AA.doC();

        doMethod(() -> {
            System.out.println("새로운 함수 정의");
        });

    }

}
