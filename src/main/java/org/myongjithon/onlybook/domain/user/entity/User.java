package org.myongjithon.onlybook.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.myongjithon.onlybook.domain.BaseEntity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String user_pw;

    @Column(nullable = false)
    private String nickname;

}
