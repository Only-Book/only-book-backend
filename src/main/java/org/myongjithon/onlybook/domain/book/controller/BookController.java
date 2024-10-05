package org.myongjithon.onlybook.domain.book.controller;

import org.myongjithon.onlybook.annotation.AuthenticatedUser;
import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.domain.book.dto.BookCommentResponseListDto;
import org.myongjithon.onlybook.domain.book.dto.BookDTO;
import org.myongjithon.onlybook.domain.book.service.BookService;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    @Autowired
    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<BookDTO>> getBookDetails(@PathVariable("id") Long id) {
        BookDTO bookDTO = bookService.getBookDetails(id);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "도서 조회 성공", bookDTO), HttpStatus.OK);
    }

    @PostMapping("/{bookid}/recommend")
    public ResponseEntity<ResponseDto<Void>> createRecommend(@PathVariable Long bookid, @AuthenticatedUser User user){
        bookService.createRecommend(bookid, user);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "도서 추천 생성 성공"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookid}/recommend")
    public ResponseEntity<ResponseDto<Void>> deleteRecommend(@PathVariable Long bookid){
        bookService.deleteRecommend(bookid);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "도서 추천 삭제 성공"), HttpStatus.OK);

    }

    @GetMapping("/{bookid}/comments")
    public ResponseEntity<ResponseDto<BookCommentResponseListDto>> getComments(@PathVariable Long bookid){
        BookCommentResponseListDto bookCommentResponseListDto = bookService.getComments(bookid);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "도서 코멘트 조회 성공", bookCommentResponseListDto), HttpStatus.OK);
    }



}