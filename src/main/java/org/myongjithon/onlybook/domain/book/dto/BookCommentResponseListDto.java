package org.myongjithon.onlybook.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BookCommentResponseListDto {
    List<BookCommentResponseDTO> bookCommentResponseDTOList;
}
