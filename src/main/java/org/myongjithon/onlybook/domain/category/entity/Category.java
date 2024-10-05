package org.myongjithon.onlybook.domain.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.BaseEntity;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
}
