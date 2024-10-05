package org.myongjithon.onlybook.domain.comment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.user.entity.User;

@Entity
@Data
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "book")
    @JsonBackReference
    private Book book;

    private String content;
}
