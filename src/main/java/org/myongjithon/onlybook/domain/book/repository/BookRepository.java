package org.myongjithon.onlybook.domain.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.myongjithon.onlybook.domain.book.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long> {
}

