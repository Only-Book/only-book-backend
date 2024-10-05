package org.myongjithon.onlybook.domain.recommend;

import jakarta.persistence.*;
import lombok.Data;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.user.entity.User;

@Entity
@Data
public class Recommend extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

}
