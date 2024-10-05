package org.myongjithon.onlybook.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.myongjithon.onlybook.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
