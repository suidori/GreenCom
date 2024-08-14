public class Ex02 {
    public static void main(String[] args) {
        BoxFactory.<Integer>peekBox(new Box<>(10));
        BoxFactory.peekBox2(new Box<>(20));
//        BoxFactory.peekBox2(new Box<>("스트링")); <-불가능
        BoxFactory.peekBox2(new Box<>(20.3d));
    }
}
