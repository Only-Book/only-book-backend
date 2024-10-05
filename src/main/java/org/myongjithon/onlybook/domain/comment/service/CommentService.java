package org.myongjithon.onlybook.domain.comment.service;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.book.repository.BookRepository;
import org.myongjithon.onlybook.domain.comment.dto.CommentCreateDTO;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.dto.CommentListDto;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.repository.CommentRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.myongjithon.onlybook.exception.NotFoundException;
import org.myongjithon.onlybook.exception.errorcode.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    @Autowired
    private final BookRepository bookRepository;

    public CommentService(CommentRepository commentRepository, BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    public void createComment(CommentCreateDTO comment, Long bookid, User user) {
        Book book= bookRepository.findById(bookid).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_BOOK));
        Comment newcomment= new Comment();
        newcomment.setContent(comment.getContent());
        newcomment.setBook(book);
        newcomment.setUser(user);
        commentRepository.save(newcomment);
    }

    public CommentListDto getAllComment(User user) {
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
        return CommentListDto.builder()
                .CommentDtolist(dtos)
                .build();

    }

    public void deleteComment(Long bookid, User user) {
        Book book= bookRepository.findById(bookid).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_BOOK));
        Comment comment= commentRepository.findBybookAndUser(book,user);
        commentRepository.delete(comment);
    }
}



