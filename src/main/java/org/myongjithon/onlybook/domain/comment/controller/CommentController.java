package org.myongjithon.onlybook.domain.comment.controller;

import jakarta.websocket.server.PathParam;
import org.myongjithon.onlybook.annotation.AuthenticatedUser;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.comment.dto.CommentCreateDTO;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.service.CommentService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private final CommentService commentService;

    @PostMapping("/{bookid}")
    public void createComment(@RequestBody CommentCreateDTO comment, @PathVariable Long bookid, @AuthenticatedUser User user) {
        commentService.createComment(comment, bookid, user);
    }

    @DeleteMapping("/{bookid}")
    public void deleteComment(@PathVariable Long bookid, @AuthenticatedUser User user) {
        commentService.deleteComment(bookid, user);
    }

    @GetMapping()
    public List<CommentDTO> getAllComment(@AuthenticatedUser User user) {
        return commentService.getAllComment(user);
    }

}
