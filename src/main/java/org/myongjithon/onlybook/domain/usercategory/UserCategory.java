package org.myongjithon.onlybook.domain.usercategory;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.category.entity.Category;
import org.myongjithon.onlybook.domain.user.entity.User;

@Entity(name = "user_category")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCategory extends BaseEntity {

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
