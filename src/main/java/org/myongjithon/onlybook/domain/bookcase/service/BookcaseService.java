package org.myongjithon.onlybook.domain.bookcase.service;

import org.myongjithon.onlybook.domain.book.dto.BookResponseDTO;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.book.repository.BookRepository;
import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;
import org.myongjithon.onlybook.domain.bookcase.repository.BookcaseRepository;

import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookcaseService {

    @Autowired
    private final BookcaseRepository bookcaseRepository;

    @Autowired
    private final BookRepository bookRepository;

    public BookcaseService(BookcaseRepository bookcaseRepository , BookRepository bookRepository) {
        this.bookcaseRepository = bookcaseRepository;
        this.bookRepository = bookRepository;
    }

    public void recommendBook(User user, Long bookid) {
        Bookcase bookcase= bookcaseRepository.findByuser(user);
        List<Book> books= bookcase.getBooks();
        Optional<Book> temp= bookRepository.findById(bookid);
        Book newbook= new Book();
        if (temp.isPresent()) newbook= temp.get();
        newbook.setRecommend(newbook.getRecommend()+1);
        bookRepository.save(newbook);
        books.add(newbook);
        bookcase.setBooks(books);
        bookcaseRepository.save(bookcase);
    }

    public List<BookResponseDTO> getAllrecommend(User user) {
        Bookcase bookcase= bookcaseRepository.findByuser(user);
        List<Book> books= bookcase.getBooks();
        List<BookResponseDTO> dtos= new ArrayList<>();
        for (Book book: books){
            BookResponseDTO dto= new BookResponseDTO();
            dto.setTitle(book.getTitle());
            dto.setImgURL(book.getImgUrl());
            dto.setAuthor(book.getAuthor());
            dto.setRecommend(book.getRecommend());
            dtos.add(dto);
        }

        return dtos;
    }

    public void deleteComment(User user, Long bookid) {
        Bookcase bookcase= bookcaseRepository.findByuser(user);
        Optional<Book> temp= bookRepository.findById(bookid);
        Book newbook= new Book();
        List<Book> books= bookcase.getBooks();
        if (temp.isPresent()) newbook= temp.get();
        newbook.setRecommend(newbook.getRecommend()-1);
        bookRepository.save(newbook);
        books.remove(newbook);
        bookcase.setBooks(books);
        bookcaseRepository.delete(bookcase);
    }

}
