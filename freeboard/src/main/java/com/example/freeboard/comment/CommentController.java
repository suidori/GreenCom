package com.example.freeboard.comment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("select")
    public ResponseEntity<List<Comment>> select() {
        List<Comment> list = commentRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody CommentReqDto commentReqDto) {
        System.out.println(commentReqDto.toString());

        ModelMapper modelMapper = new ModelMapper();

        Comment comment = modelMapper.map(commentReqDto, Comment.class);

        commentRepository.save(comment);

        return ResponseEntity.status(200).body("insert");
    }


    @PutMapping("/delete/{fidx}/{c_idx}/{c_password}")
    public ResponseEntity<String> delete(@PathVariable("fidx") long fidx,
                                         @PathVariable("c_idx") int c_idx,
                                         @PathVariable("c_password") String c_password) {

        if (commentService.deleteComment(fidx, c_idx, c_password)) { //변수 확인
            return ResponseEntity.ok("댓글이 삭제되었습니다.");
        } else {
            return ResponseEntity.ok("실패했습니다.");
        }
    }

}
