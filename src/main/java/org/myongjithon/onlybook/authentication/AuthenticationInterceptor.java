package org.myongjithon.onlybook.authentication;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.myongjithon.onlybook.domain.user.repository.UserRepository;
import org.myongjithon.onlybook.exception.NotFoundException;
import org.myongjithon.onlybook.exception.errorcode.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationContext authenticationContext;
    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String accessToken = AuthenticationExtractor.extract(request);
        Long userId = Long.parseLong(jwtTokenProvider.getPayload(accessToken));
        User user = this.userRepository.findById(userId).orElseThrow(() -> new NotFoundException(ErrorCode.USERID_NOT_FOUND));
        authenticationContext.setPrincipal(user);
        return true;
    }
}