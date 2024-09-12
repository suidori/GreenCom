package com.example.nyh.ex07.freeboard;

import com.nyh.ex07.freeboard.FreeBoard;
import com.nyh.ex07.freeboard.FreeBoardRepository;
import com.nyh.ex07.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FreeBoardRepositoryTest {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Test
    void insertTest() {

        User user = User.builder()
                .name("홍길동")
                .age(20)
                .email("bbb@naver.com")
                .password("password")
                .build();

        FreeBoard freeBoard = FreeBoard.builder()
                .title("제목")
                .content("내용")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);
    }

    @Test
    void selectTest() {
        freeBoardRepository.findAll();
    }

}
