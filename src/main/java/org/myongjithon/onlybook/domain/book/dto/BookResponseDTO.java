package org.myongjithon.onlybook.domain.book.dto;

import lombok.Data;
import org.myongjithon.onlybook.domain.comment.entity.Comment;

import java.util.List;
@Data
public class BookResponseDTO {
    private String imgURL;
    private String title;
    private String author;
    private int recommend;
}
