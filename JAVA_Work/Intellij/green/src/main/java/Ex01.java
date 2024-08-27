public class Ex01 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1+i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
