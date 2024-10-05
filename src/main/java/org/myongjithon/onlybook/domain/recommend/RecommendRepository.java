package org.myongjithon.onlybook.domain.recommend;

import org.myongjithon.onlybook.domain.book.entity.Book;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend,Long> {
    Recommend findBybook(Book book);
    List<Recommend> findByuser(User user);
}
