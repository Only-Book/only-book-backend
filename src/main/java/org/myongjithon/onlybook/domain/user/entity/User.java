package org.myongjithon.onlybook.domain.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.myongjithon.onlybook.domain.BaseEntity;
import org.myongjithon.onlybook.domain.comment.Comment;
import org.myongjithon.onlybook.domain.usercategory.UserCategory;

import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserCategory> user_category;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

}
