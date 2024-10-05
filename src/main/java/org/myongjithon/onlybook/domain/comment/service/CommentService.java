package org.myongjithon.onlybook.domain.comment.service;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.repository.CommentRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<CommentDTO> getAllComment(User user){
        List<Comment> comments= commentRepository.findByUser(user);
        List<CommentDTO> dtos=  new ArrayList<>();
        for(Comment comment:  comments){
             CommentDTO dto=  new CommentDTO();
            Book book= comment.getBook();
            dto.setContent(comment.getContent());
            dto.setTitle(book.getTitle());
            dto.setImgUrl(book.getImgUrl());
            dtos.add(dto);
        }
        return dtos;
    }

    public void deleteComment(Long commentid) {
        Optional<Comment> temp= commentRepository.findById(commentid);
        temp.ifPresent(commentRepository::delete);
    }
}