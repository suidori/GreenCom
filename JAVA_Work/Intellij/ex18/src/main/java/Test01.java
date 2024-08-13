/*
1. Person 클래스에서 comparable을 상속받아 compareTo메서드를 재정의해서
이름글자의 갯수로 오름차순 내림차순으로 하였는데,
이 탐색의 기준이 이름(사전편찬순으로) 되도록 수정해보자.
ㄱ,ㄴ,ㄷ,ㄹ,ㅁ,ㅂ,ㅅ,
*/

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        Person[] parr = {
                new Person("나다라", 10),
                new Person("가가나라", 50),
                new Person("가나다라", 10),
                new Person("가나다", 20),
                new Person("가가나", 50),
                new Person("가가나", 40),
                new Person("가가나", 30)
        };

        Arrays.sort(parr);

        for (Person p : parr){
            System.out.println(p);
        }

    }
}
