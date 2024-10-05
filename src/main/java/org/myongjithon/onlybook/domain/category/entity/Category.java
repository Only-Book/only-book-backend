package org.myongjithon.onlybook.domain.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.myongjithon.onlybook.domain.BaseEntity;

@Entity
public class Category extends BaseEntity {
    private String name;
}
