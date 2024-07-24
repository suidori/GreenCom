import BackGround.Order;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println("어서오세요!");
        order.order();
        System.out.printf("%d원을 결제 해 주세요", order.sum);
    }
}