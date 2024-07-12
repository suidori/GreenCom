// 배열[10,20,30,40,50] 알맞은 코드를 넣어 총합과 평균을 구하시오


public class Test01 {
    public static void main(String[] args) {
        int ar[] = {10, 20, 30, 40, 50};
        int sum = 0;
        for(int e:ar){
            sum +=e;
        }
        System.out.printf("총합은 %d 입니다.\n", sum);
        System.out.printf("평균은 %d 입니다.", sum/ar.length);
    }
}
