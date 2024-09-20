package com.example.freeboard.freeboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoardResponsePageDto {

    @Schema(hidden = true)
    @JsonIgnore
    private List<FreeBoard> content;
    private List<FreeBoardResponseDto> list;
    private int totalElements;
    private int totalPages;
    private int size;

}