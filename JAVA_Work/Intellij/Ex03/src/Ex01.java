class A{
    int num = 10;
    public void doA(){
        System.out.println("아무거나 만들기");
    }
}

public class Ex01 {
    public static void main(String[] args) {
        int num = 1;

        System.out.println(num);
        A a = new A();

        System.out.println(a.num);
        a.doA();

    }
}
