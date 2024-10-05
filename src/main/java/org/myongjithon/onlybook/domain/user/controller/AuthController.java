package org.myongjithon.onlybook.domain.user.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.domain.user.dto.auth.LoginDto;
import org.myongjithon.onlybook.domain.user.dto.user.CreateUserDto;
import org.myongjithon.onlybook.domain.user.service.AuthService;
import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 회원 가입
    @PostMapping("/auth/signin")
    public ResponseEntity<ResponseDto<Void>> createUser(@Validated @RequestBody CreateUserDto createUserDto) {
        this.authService.createUser(createUserDto);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "create User"), HttpStatus.OK);
    }

    // 로그인
    @PostMapping("/auth/login")
    public ResponseEntity<ResponseDto<Void>> login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        this.authService.login(loginDto, response);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "login successfully"), HttpStatus.OK);
    }

    // 로그아웃
    @PostMapping("/auth/logout")
    public ResponseEntity<ResponseDto<Void>> logout(HttpServletResponse response) {
        this.authService.logout(response);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "logout successfully"), HttpStatus.OK);
    }

}

