package org.myongjithon.onlybook.domain.book.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.book.dto.BookCommentResponseDTO;
import org.myongjithon.onlybook.domain.book.dto.BookDTO;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.book.repository.BookRepository;
import org.myongjithon.onlybook.domain.category.repository.CategoryRepository;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.comment.repository.CommentRepository;
import org.myongjithon.onlybook.domain.recommend.Recommend;
import org.myongjithon.onlybook.domain.recommend.RecommendRepository;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private RecommendRepository recommendRepository;

    @Autowired
    private final CommentRepository commentRepository;

    public BookDTO getBookDetails(Long id) {
        Book book = bookRepository.findById(id).orElse(null);

        if (book != null) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setPrice(book.getPrice());
            bookDTO.setImgUrl(book.getImgUrl());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setCategory(book.getCategory().getName());
            bookDTO.setPublish_date(book.getPublishDate().toString());
            return bookDTO;
        }
        return null;
    }

    public void createRecommend(Long bookid, User user) {
        Optional<Book> temp= bookRepository.findById(bookid);
        Book book= new Book();
        if(temp.isPresent())  book= temp.get();
        book.setRecommend(book.getRecommend()+1);
        bookRepository.save(book);
        Recommend recommend= new Recommend();
        recommend.setBook(book);
        recommend.setUser(user);
        recommendRepository.save(recommend);
    }

    public void deleteRecommend(Long bookid) {
        Optional<Book> temp= bookRepository.findById(bookid);
        Book book= new Book();
        if(temp.isPresent())  book= temp.get();
        book.setRecommend(book.getRecommend()-1);
        bookRepository.save(book);
        Recommend recommend= recommendRepository.findBybook(book);
        recommendRepository.delete(recommend);
    }

    public List<BookCommentResponseDTO> getComments(Long bookid) {
        Optional<Book> temp= bookRepository.findById(bookid);
        List<BookCommentResponseDTO> dtos= new ArrayList<>();
        Book book= new Book();
        if(temp.isPresent())  book= temp.get();
        List<Comment> comments= commentRepository.findBybook(book);
        for(Comment comment: comments){
            BookCommentResponseDTO dto= new BookCommentResponseDTO();
            dto.setContent(comment.getContent());
            dto.setNickname(comment.getUser().getNickname());
            dtos.add(dto);
        }
        return dtos;
    }
}
