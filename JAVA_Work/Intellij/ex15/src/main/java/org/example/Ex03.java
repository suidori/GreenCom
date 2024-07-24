package org.example;

public class Ex03 {

    public static void main(String[] args) {

        try {
            throw new MyException(
                    new ErrorCode(
                            "ID를 입력하세요",
                            "A101",
                            "ID는 영어로 입력해야 합니다."
                    )
            );
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
