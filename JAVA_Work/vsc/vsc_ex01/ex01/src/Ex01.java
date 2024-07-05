public class Ex01 {
    public static void main(String[] args) {
        int result = 0;
        for(int num =1 ; num<=20; num++){
            if(num%2 != 0 && num%3 !=0){
                result += num;
                System.out.println(result);
            }
        }
    }
}
