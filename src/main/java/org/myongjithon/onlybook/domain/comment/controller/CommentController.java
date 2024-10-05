package org.myongjithon.onlybook.domain.comment.controller;

import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.service.CommentService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/create")
    public void createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
    }

    @GetMapping("/all")
    public List<CommentDTO> getAllComment(@RequestBody User user){
        return commentService.getAllComment(user);
    }

}
