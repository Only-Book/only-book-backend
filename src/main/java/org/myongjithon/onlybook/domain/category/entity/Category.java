package org.myongjithon.onlybook.domain.category.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.usercategory.UserCategory;

import java.util.List;

@Entity
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
