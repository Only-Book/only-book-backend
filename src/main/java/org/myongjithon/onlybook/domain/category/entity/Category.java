package org.myongjithon.onlybook.domain.category.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.usercategory.UserCategory;

import java.util.List;

@Entity
@Data
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
