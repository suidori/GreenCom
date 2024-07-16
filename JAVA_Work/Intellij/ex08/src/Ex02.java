import Package01.PackageTest;

public class Ex02 extends PackageTest {
    int zzz = 10;

    Ex02() {
        System.out.println("여기에서 할거에요");
        System.out.println(zzz);
        System.out.println(aaa);
    }

    public static void main(String[] args) {
        Ex02 ex02 = new Ex02();

    }
}
