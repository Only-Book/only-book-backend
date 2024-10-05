package org.myongjithon.onlybook.domain.comment.repository;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUser(User user);
    List<Comment> findBybook(Book book);
    Comment findBybookAndUser(Book book, User user);
}
