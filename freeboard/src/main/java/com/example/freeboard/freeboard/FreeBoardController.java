package com.example.freeboard.freeboard;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("freeboard")
@RequiredArgsConstructor
public class FreeBoardController {

    private static final Logger log = LoggerFactory.getLogger(FreeBoardController.class);
    private final FreeBoardRepository freeBoardRepository;

    @GetMapping("view/{idx}")
    public ResponseEntity<FreeBoardResponseDto> findOne(@PathVariable(name = "idx") long idx){

        Optional<FreeBoard> freeBoard = freeBoardRepository.findById(idx);

        ModelMapper modelMapper = new ModelMapper();
        FreeBoardResponseDto freeBoardResponseDto = modelMapper.map(freeBoard.get(), FreeBoardResponseDto.class);

        return ResponseEntity.ok(freeBoardResponseDto);
    }

    @GetMapping("select")
    public ResponseEntity<FreeBoardResponsePageDto> select(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
                                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "ftimestamp");

        Pageable pageable = PageRequest.of(pageNum, size, sort);

        Page<FreeBoard> page = freeBoardRepository.findAll(pageable);

        System.out.println("elements: " + page.getTotalElements());
        System.out.println("pages: " + page.getTotalPages());

        FreeBoardResponsePageDto freeBoardResponsePageDto
                = new ModelMapper()
                .map(page, FreeBoardResponsePageDto.class);

        List<FreeBoardResponseDto> list = new ArrayList<>();
        for (FreeBoard freeBoard : freeBoardResponsePageDto.getContent()) {

            FreeBoardResponseDto freeBoardResponseDto
                    = new ModelMapper().map(freeBoard, FreeBoardResponseDto.class);

            DateTimeFormatter dateTimeFormatter
                    = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");

            freeBoardResponseDto.setFtimestamp(dateTimeFormatter.format(freeBoard.getFtimestamp()));

            list.add(freeBoardResponseDto);
        }
        freeBoardResponsePageDto.setList(list);

        return ResponseEntity.ok(freeBoardResponsePageDto);
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody FreeBoardReqDto freeBoardReqDto) {

        ModelMapper modelMapper = new ModelMapper();
        FreeBoard freeBoard = modelMapper.map(freeBoardReqDto, FreeBoard.class);

        freeBoardRepository.save(freeBoard);

        return ResponseEntity.status(200).body("insert");
    }

}