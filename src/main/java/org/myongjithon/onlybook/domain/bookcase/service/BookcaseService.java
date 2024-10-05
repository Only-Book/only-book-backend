package org.myongjithon.onlybook.domain.bookcase.service;

import org.myongjithon.onlybook.domain.book.dto.BookResponseDTO;
import org.myongjithon.onlybook.domain.book.dto.BookResponseListDto;
import org.myongjithon.onlybook.domain.book.entity.Book;

import org.myongjithon.onlybook.domain.recommend.Recommend;
import org.myongjithon.onlybook.domain.recommend.RecommendRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookcaseService {

    @Autowired
    private final RecommendRepository recommendRepository;

    public BookcaseService(RecommendRepository recommendRepository) {
        this.recommendRepository = recommendRepository;
    }


    public BookResponseListDto getAllrecommend(User user) {
        List<Recommend> books= recommendRepository.findByuser(user);
        List<BookResponseDTO> dtos= new ArrayList<>();
        for (Recommend book: books){
            Book newbook= book.getBook();
            BookResponseDTO dto= new BookResponseDTO();
            dto.setTitle(newbook.getTitle());
            dto.setImgURL(newbook.getImgUrl());
            dto.setAuthor(newbook.getAuthor());
            dto.setRecommend(newbook.getRecommend());
            dtos.add(dto);
        }
        return BookResponseListDto.builder()
                .bookResponseDTOList(dtos)
                .build();
    }


}
