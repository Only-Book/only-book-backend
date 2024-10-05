package org.myongjithon.onlybook.domain.bookcase.entity;

import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookcaseRepository extends JpaRepository<Bookcase, Long> {
}
