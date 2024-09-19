package com.example.freeboard.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public boolean deleteComment(long fidx, int c_idx, String c_password) {
        System.out.println(fidx);
        System.out.println(c_idx);
        System.out.println(c_password);
        CommentId commentId = new CommentId(c_idx, fidx);//복합 키 생성
        Optional<Comment> optionalComment = commentRepository.findById(commentId); //복합 키 검색
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();//언박싱
            if (c_password.equals(comment.getC_password())) {//비밀번호 비교

                List<Comment> responseComments = commentRepository.findByFidx(fidx); //같은 게시물에 달린 댓글 검색

                for (Comment reply : responseComments) {
                    if (reply.getC_response_index()!=null && reply.getC_response_index() == c_idx) { //대댓글 검색
                        comment.setC_avail(false); //있으면 원댓글 false
                        commentRepository.save(comment); //save
                        return true; //확인용 변수 체크
                    }
                }
                commentRepository.delete(comment); //대댓글 없으면 삭제
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
