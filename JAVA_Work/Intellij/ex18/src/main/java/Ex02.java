public class Ex02 {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Box<Apple>> box3 = new Box<>();

        box1.setObj(new Apple());
        box2.setObj(new Orange());
        box3.setObj(box1);

        Apple apple = box1.getObj();
        Orange orange = box2.getObj();

    }
}
