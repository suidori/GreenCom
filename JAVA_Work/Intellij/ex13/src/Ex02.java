import Friend.*;

public class Ex02 {

    public static void main(String[] args) {

        Friend[] friend = new Friend[10];

        friend[0] = new ComFriend("홍길동", "010-1234-1234", "개발팀");
//        friend[1] = new UniFriend("대학친구", "전화번호", "컴퓨터");

        friend[0].showInfo();

    }

}
