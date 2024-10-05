package org.myongjithon.onlybook.authentication;

import lombok.Getter;
import lombok.Setter;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Setter
@Getter
@Component
@RequestScope
public class AuthenticationContext {
    private User principal;
}