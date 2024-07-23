import inter.Printable;

public class Ex02 {
    public static void main(String[] args) {
        Printable prn = System.out::println; //미친 람다 새끼;;
        prn.print("새로운 문서 출력");
    }
}