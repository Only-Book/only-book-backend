package org.myongjithon.onlybook.domain.comment.dto;

import lombok.Data;
import org.myongjithon.onlybook.domain.book.entity.Book;

@Data
public class CommentDTO {

    private String content;
    private String title;
    private String imgUrl;

}
