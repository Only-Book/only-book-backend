package org.myongjithon.onlybook.domain.book.controller;

import org.myongjithon.onlybook.domain.book.dto.BookDTO;
import org.myongjithon.onlybook.domain.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookDetails(@PathVariable("id") Long id) {
        try {
            BookDTO bookDTO = bookService.getBookDetails(id);
            if (bookDTO != null) {
                return ResponseEntity.ok(bookDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}