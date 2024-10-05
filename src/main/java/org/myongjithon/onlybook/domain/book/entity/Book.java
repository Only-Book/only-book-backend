package org.myongjithon.onlybook.domain.book.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.myongjithon.onlybook.domain.BaseEntity;

@Entity

public class Book extends BaseEntity {


    private String title;
    private String publish_date;
    private String author;
    private String price;
    private String description;
    private String category;
}
