package org.myongjithon.onlybook.domain.book.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String title;
    private String author;
    private String price;
    private String imgUrl;
    private String description;
    private String category;
    private String publish_date;
}