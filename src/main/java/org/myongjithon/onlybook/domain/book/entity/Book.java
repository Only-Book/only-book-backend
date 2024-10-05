package org.myongjithon.onlybook.domain.book.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.category.entity.Category;
import org.myongjithon.onlybook.domain.comment.entity.Comment;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;

import java.util.List;

@Entity
@Data
public class Book extends BaseEntity {


    private String title;

    private String author;

    private String price;


    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private LocalDate publishDate;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int recommend;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "bookcase")
    @JsonBackReference
    private Bookcase bookcase;


}
