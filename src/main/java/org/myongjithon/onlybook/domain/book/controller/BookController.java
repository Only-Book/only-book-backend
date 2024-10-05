package org.myongjithon.onlybook.domain.book.controller;

import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.domain.book.dto.BookDTO;
import org.myongjithon.onlybook.domain.book.service.BookService;
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
}