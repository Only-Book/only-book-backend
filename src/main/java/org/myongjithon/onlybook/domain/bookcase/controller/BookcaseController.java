package org.myongjithon.onlybook.domain.bookcase.controller;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.bookcase.service.BookcaseService;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bookcase")
public class BookcaseController {
    @Autowired
    private final BookcaseService bookcaseService;

    public BookcaseController(BookcaseService bookcaseService) {
        this.bookcaseService = bookcaseService;
    }

    @PostMapping("/recommend")
    public void recommendBook(@RequestBody User user, @RequestBody Book book){
        bookcaseService.recommendBook(user, book);
    }

//    @GetMapping("/all")
//    public List<Book> getAllrecommend(@RequestBody User user){
//        return bookcaseService.getAllrecommend(user);
//    }
}
