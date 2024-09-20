package com.example.freeboard.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@IdClass(CommentId.class)
public class Comment {

    @Id
    private int c_idx;

    @Id
    private long fidx;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean c_avail;

    @Column(length = 32, nullable = false)
    private String c_nickname;

    @Column(length = 16, nullable = false)
    private String c_password;

    @Lob
    @Column(nullable = false)
    private String c_body;

    private LocalDateTime c_timestamp = LocalDateTime.now();

    @Column(nullable = true)
    private Integer c_response_index;
}