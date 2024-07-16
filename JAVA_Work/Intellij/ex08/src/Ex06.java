class Test{
    public static void doA(){
        System.out.println("Static doA");
    }
    public void doB(){
        System.out.println("just doB");
    }
}
public class Ex06 {
    public static void main(String[] args) {
        Test.doA();
        Test test = new Test();
        test.doB();
    }
}
