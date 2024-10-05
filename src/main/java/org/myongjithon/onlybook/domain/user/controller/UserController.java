package org.myongjithon.onlybook.domain.user.controller;
import lombok.RequiredArgsConstructor;
import org.myongjithon.onlybook.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
