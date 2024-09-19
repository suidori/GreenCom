package com.example.freeboard.freeboard;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class FreeBoardController {

    private final FreeBoardRepository freeBoardRepository;

    @GetMapping("select")
    public ResponseEntity<List<FreeBoard>> select(){
        List<FreeBoard> list = freeBoardRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto){

        ModelMapper modelMapper = new ModelMapper();
        FreeBoard freeBoard = modelMapper.map(freeBoardReqDto, FreeBoard.class);

        freeBoardRepository.save(freeBoard);

        return ResponseEntity.status(200).body("insert");
    }

}