package org.myongjithon.onlybook.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.myongjithon.onlybook.domain.BaseEntity;


@Entity
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
