package org.myongjithon.onlybook.domain.comment.controller;

import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.annotation.AuthenticatedUser;
import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.domain.comment.dto.CommentCreateDTO;
import org.myongjithon.onlybook.domain.comment.dto.CommentListDto;
import org.myongjithon.onlybook.domain.comment.service.CommentService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private final CommentService commentService;

    @PostMapping("/{bookid}")
    public ResponseEntity<ResponseDto<Void>> createComment(@RequestBody CommentCreateDTO comment, @PathVariable Long bookid, @AuthenticatedUser User user) {
        commentService.createComment(comment, bookid, user);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "코멘트 생성 성공"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookid}")
    public ResponseEntity<ResponseDto<Void>> deleteComment(@PathVariable Long bookid, @AuthenticatedUser User user) {
        commentService.deleteComment(bookid, user);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "코멘트 삭제 성공"), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ResponseDto<CommentListDto>> getAllComment(@AuthenticatedUser User user) {
        CommentListDto commentListDto = this.commentService.getAllComment(user);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "코멘트 조회 성공", commentListDto), HttpStatus.OK);
    }

}
