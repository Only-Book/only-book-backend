package org.myongjithon.onlybook.domain.comment.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.service.CommentService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private final CommentService commentService;


    @PostMapping("/create")
    public void createComment(@RequestBody Comment comment){
        commentService.createComment(comment);
    }


}
