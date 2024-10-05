package org.myongjithon.onlybook.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CommentListDto {
    private List<CommentDTO> CommentDtolist;
}
