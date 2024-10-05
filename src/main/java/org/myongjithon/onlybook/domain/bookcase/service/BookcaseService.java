package org.myongjithon.onlybook.domain.bookcase.service;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;
import org.myongjithon.onlybook.domain.bookcase.repository.BookcaseRepository;
import org.myongjithon.onlybook.domain.comment.dto.CommentDTO;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.repository.CommentRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookcaseService {

    @Autowired
    private final BookcaseRepository bookcaseRepository;

    public BookcaseService(BookcaseRepository bookcaseRepository) {
        this.bookcaseRepository = bookcaseRepository;
    }


    public void recommendBook(User user, Book book) {
        Bookcase bookcase= bookcaseRepository.findByuser(user);
        List<Book> books= bookcase.getBooks();
        books.add(book);
        bookcase.setBooks(books);
        bookcaseRepository.save(bookcase);
    }

//    public List<Book> getAllrecommend(User user) {
//        Bookcase bookcase= bookcaseRepository.findByuser(user);
//        Book book= new Book();
//    }
}
