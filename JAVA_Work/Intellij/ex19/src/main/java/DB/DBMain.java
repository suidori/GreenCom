package DB;

import java.util.Scanner;

public class DBMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DBRepository dbRepository = new DBRepository();
        boolean replay = false;
        while(true){
            System.out.println("""
                    뭐할래?
                    1. 입력
                    2. 조회
                    3. 수정
                    4. 삭제
                    5. 종료
                    """);
            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    dbRepository.insert();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    replay = true;
                    break;
                default:
                    break;
            }

            if(replay){
                System.out.println("종료합니다.");
                break;
            }

        }

    }
}
