package org.myongjithon.onlybook.domain.bookcase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.user.entity.User;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookcase extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}

