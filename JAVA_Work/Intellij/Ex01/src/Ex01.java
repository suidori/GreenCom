public class Ex01 {

    // 1+2+3+4+~10까지 더하는 메서드
    public static int doA() {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += i;
        }
        return sum;
    }

    // 1*2*3*4*5*~10까지 더하는 메서드
    public static int doB() {
        int sum = 1;
        for (int i = 1; i < 11; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("doA = " + doA());
        System.out.println("doB =" + doB());


    }
}
