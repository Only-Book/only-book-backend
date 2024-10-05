package org.myongjithon.onlybook.domain.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.bookcase.Bookcase;
import org.myongjithon.onlybook.domain.comment.Comment;

import java.util.List;

@Entity

public class Book extends BaseEntity {

    private String title;
    private String publish_date;
    private String author;
    private String price;
    private String description;
    private String category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "bookcase")
    @JsonBackReference
    private Bookcase bookcases;

}
