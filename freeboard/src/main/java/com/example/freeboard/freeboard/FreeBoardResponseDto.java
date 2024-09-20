package com.example.freeboard.freeboard;

import lombok.Data;

@Data
public class FreeBoardResponseDto {
    private long f_idx;
    private boolean f_avail;
    private String f_nickname;
    private String f_password;
    private String f_title;
    private String f_body;
    private String ftimestamp;
}
