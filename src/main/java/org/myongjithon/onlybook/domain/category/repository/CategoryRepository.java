package org.myongjithon.onlybook.domain.category.repository;

import org.myongjithon.onlybook.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}