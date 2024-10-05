package org.myongjithon.onlybook.domain.bookcase.controller;

import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.annotation.AuthenticatedUser;
import org.myongjithon.onlybook.domain.book.dto.BookResponseListDto;
import org.myongjithon.onlybook.domain.bookcase.service.BookcaseService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bookcase")
public class BookcaseController {
    @Autowired
    private final BookcaseService bookcaseService;

    public BookcaseController(BookcaseService bookcaseService) {
        this.bookcaseService = bookcaseService;
    }

    @GetMapping()
    public ResponseEntity<ResponseDto<BookResponseListDto>> getAllrecommend(@AuthenticatedUser User user){
        BookResponseListDto bookResponseListDto = bookcaseService.getAllrecommend(user);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "모든 추천 도서 목록 조회 성공", bookResponseListDto), HttpStatus.OK);

    }


}
