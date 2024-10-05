package org.myongjithon.onlybook.domain.comment.service;

import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.repository.CommentRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

}
