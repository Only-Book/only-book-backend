package org.myongjithon.onlybook.domain.comment.controller;

import jakarta.websocket.server.PathParam;
import org.myongjithon.onlybook.annotation.AuthenticatedUser;
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

    @DeleteMapping("/delete/{commentid}")
    public void deleteComment(@PathVariable Long commentid){
        commentService.deleteComment(commentid);
    }

    @GetMapping("/all")
    public List<CommentDTO> getAllComment(@AuthenticatedUser User user){
        return commentService.getAllComment(user);
    }

}
