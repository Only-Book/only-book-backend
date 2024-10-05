package org.myongjithon.onlybook.domain.book.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.book.dto.BookDTO;
import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.book.repository.BookRepository;
import org.myongjithon.onlybook.domain.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

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
}
