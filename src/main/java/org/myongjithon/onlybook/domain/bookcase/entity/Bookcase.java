package org.myongjithon.onlybook.domain.bookcase.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.user.entity.User;

import java.util.List;

@Entity
@Data
@Builder
public class Bookcase extends BaseEntity {

    @OneToMany(mappedBy = "bookcase", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Book> books;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}

