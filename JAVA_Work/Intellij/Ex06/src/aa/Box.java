package aa;

public class Box {
    String name;

    public Box(){
        System.out.println("기본생성자");
    }

    public Box(String n) {
        name = n;
        System.out.println("다른생성자");
    }

    public String toString() {
        return "Box name = " + name;
    }
}
