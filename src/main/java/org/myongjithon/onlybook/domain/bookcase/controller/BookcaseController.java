package org.myongjithon.onlybook.domain.bookcase.controller;

import org.myongjithon.onlybook.annotation.AuthenticatedUser;
import org.myongjithon.onlybook.domain.book.dto.BookResponseDTO;
import org.myongjithon.onlybook.domain.bookcase.service.BookcaseService;
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

    @PostMapping("/{bookid}")
    public void recommendBook(@AuthenticatedUser User user, @PathVariable Long bookid){
        bookcaseService.recommendBook(user, bookid);
    }

    @DeleteMapping("/delete/{bookid}")
    public void deleteComment(@AuthenticatedUser User user, @PathVariable Long bookid){
        bookcaseService.deleteComment(user,bookid);
    }

    @GetMapping("/all")
    public List<BookResponseDTO> getAllrecommend(@RequestBody User user){
        return bookcaseService.getAllrecommend(user);
    }


}
