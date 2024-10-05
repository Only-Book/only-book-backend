package org.myongjithon.onlybook.domain.book.repository;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
