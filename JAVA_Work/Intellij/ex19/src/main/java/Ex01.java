public class Ex01 {
    public static void main(String[] args) {
        Box<String> steelBox = new SteelBox<>("test");
        steelBox.setT("test");

        System.out.println(steelBox.getT());
    }
}
