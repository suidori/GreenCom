//500x + 700y + 400z = 3500 일때 x  y z 의 경우를 전부 구하라
//단, x, y, z는 모두 1 이상이다.

public class Ex03 {
    public static void main(String[] args) {
        int money = 1900;
        System.out.println("구매할 수 있는 물건의 개수");
        System.out.println("[ 크림빵, 새우깡, 콜라 ]");

        for( int x = 0;  x <= 3; x++){
            for(int y = 0; (money-500*x -700*y) >=0; y++ ){
                for(int z = 0; (money-500*x -700*y - 400*z)>= 0; z++){
                    if ((money - 500*x - 700*y - 400*z) == 0) {
                        System.out.println("[ " + (x + 1) + "개, " + (y + 1) + "개, " + (z + 1) + "개 ]");
                    }
                }
            }
        }
    }
}
