package com.example.freeboard.freeboard;

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
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long f_idx;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private boolean f_avail = true;

    @Column(length = 32, nullable = false)
    private String f_nickname;
    @Column(length = 16, nullable = false)
    private String f_password;

    @Column(length = 80, nullable = false)
    private String f_title;

    @Lob
    @Column(nullable = false)
    private String f_body;

    private LocalDateTime ftimestamp;

    @PrePersist
    public void prePersist() {
        if (this.ftimestamp == null) {
            this.ftimestamp = LocalDateTime.now();
        }
    }

}
