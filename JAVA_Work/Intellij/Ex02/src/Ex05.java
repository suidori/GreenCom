//방정식 의 모든 해를 구하시오 2x+4y=10
//0<=x<=10, 0<=y<=10 .

public class Ex05 {
    public static void main(String[] args) {
        System.out.println("2x + 4y = 10 의 모든 해를 구해봅시다.");
        System.out.println("해는 [ x, y ] 형태로 출력됩니다.");
        for (int x = 0; (10 - 2 * x) >= 0; x++) {
            for (int y = 0; (10 - 2 * x - 4 * y) >= 0; y++) {
                if (10 - 2 * x - 4 * y == 0) {
                    System.out.println("[ " + x + ", " + y + " ]");
                }
            }
        }
    }
}