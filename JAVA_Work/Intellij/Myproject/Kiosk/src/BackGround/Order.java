package BackGround;

import java.util.Scanner;

public class Order {
    public boolean replay = true;
    public final String[] MENU = {"녹차라떼", "카페라떼", "율무차", "아메리카노", "밀크커피"};
    public final int[] PRICE = {2000, 1500, 1500, 1000, 1300};
    int orderMenu = 0;
    int orderCount = 0;
    public int sum = 0;
    Scanner sc = new Scanner(System.in);

    public void order() {
        orderMenu();
        orderCount();
        System.out.printf("현재 총 결제 금액은 %d원 입니다.\n", sum);
        System.out.println("추가로 주문하시겠습니까?");

        while (true) {
            switch (sc.nextLine()) {
                case ("y"):
                    order();
                    return;
                case ("n"):
                    return;
                default:
                    System.out.println("y나 n을 입력 해 주세요.");
            }
        }
    }

    public void orderMenu() {
        System.out.println("원하시는 메뉴의 번호를 입력해 주세요.");
        for (int i = 0; i < MENU.length; i++) {
            System.out.printf("[ %d. %s: %d원 ]\n", i + 1, MENU[i], PRICE[i]);
        }

        try {
            orderMenu = sc.nextInt() - 1;
        } catch (Exception e) {
            sc.nextLine();
            orderMenu();
            return;
        }

        if (orderMenu < 0 || orderMenu > MENU.length - 1) {
            orderMenu();
            return;
        }

        System.out.printf("%s를 선택하셨습니다. 가격은 %d원 입니다.\n", MENU[orderMenu], PRICE[orderMenu]);
    }

    public void orderCount() {
        System.out.println("몇 잔을 구매하시겠습니까?");

        try {
            orderCount = sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
            orderCount();
            return;
        }

        if (orderCount <= 0) {
            System.out.println("음료 주문을 취소했습니다.");
            return;
        }

        System.out.printf("%s %d잔의 가격은 %d원 입니다.\n", MENU[orderMenu], orderCount, orderCount * PRICE[orderMenu]);
        sum += orderCount * PRICE[orderMenu];
    }

}