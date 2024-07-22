import Friend.ComFriend;
import Friend.UniFriend;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        UniFriend[] uniFriends = new UniFriend[10];
        ComFriend[] comFriends = new ComFriend[10];

        int ucnt = 0;
        int ccnt = 0;

        uniFriends[ucnt++] = new UniFriend
                ("홍길동",
                "010-1234-5678",
                "경영학과");

        for (int i = 0; i < ucnt; i++) {
            uniFriends[i].showInfo();
        }

        System.out.println();

        comFriends[ccnt++] = new ComFriend
                ("임꺽정",
                        "010-9876-5432",
                        "홍보팀");
        for (int i = 0; i < ccnt; i++) {
            comFriends[i].showInfo();
        }
    }
}
