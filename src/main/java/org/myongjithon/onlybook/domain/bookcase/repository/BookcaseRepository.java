package org.myongjithon.onlybook.domain.bookcase.repository;

import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookcaseRepository extends JpaRepository<Bookcase, Long> {
    Bookcase findByuser(User user);
}
