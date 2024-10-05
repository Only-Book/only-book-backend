package org.myongjithon.onlybook.domain.user.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.authentication.JwtEncoder;
import org.myongjithon.onlybook.authentication.JwtTokenProvider;
import org.myongjithon.onlybook.authentication.PasswordHashEncryption;
import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;
import org.myongjithon.onlybook.domain.bookcase.repository.BookcaseRepository;
import org.myongjithon.onlybook.domain.category.entity.Category;
import org.myongjithon.onlybook.domain.category.entity.CategoryRepository;
import org.myongjithon.onlybook.domain.comment.entity.Comment;
import org.myongjithon.onlybook.domain.user.dto.auth.LoginDto;
import org.myongjithon.onlybook.domain.user.dto.user.CreateUserDto;
import org.myongjithon.onlybook.domain.user.entity.User;
import org.myongjithon.onlybook.domain.user.repository.UserRepository;
import org.myongjithon.onlybook.domain.usercategory.UserCategory;
import org.myongjithon.onlybook.domain.usercategory.UserCategoryRepository;
import org.myongjithon.onlybook.exception.ConflictException;
import org.myongjithon.onlybook.exception.NotFoundException;
import org.myongjithon.onlybook.exception.UnauthorizedException;
import org.myongjithon.onlybook.exception.errorcode.ErrorCode;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordHashEncryption passwordHashEncryption;
    private final UserRepository userRepository;
    private final BookcaseRepository bookcaseRepository;
    private final CategoryRepository categoryRepository;
    private final UserCategoryRepository userCategoryRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원 가입
    public void createUser(CreateUserDto createUserDto) {
        // 아이디 중복 검사
        this.isUserIdExist(createUserDto.getId());

        String encryptedPassword = this.passwordHashEncryption.encrypt(createUserDto.getPassword());
        List<Comment> comments = new ArrayList<>();

        // 유저 생성
        User user = User.builder()
                .userId(createUserDto.getId())
                .nickname(createUserDto.getNickname())
                .userPw(encryptedPassword)
                .comments(comments)
                .build();
        userRepository.save(user);

        // bookcase 생성
        Bookcase bookcase = Bookcase.builder()
                .user(user)
                .build();
        bookcaseRepository.save(bookcase);

        // userCagetory 생성
        for(Long c_id : createUserDto.getCategoryIdList()){
            Category category = categoryRepository.findById(c_id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_CATEGORY));
            UserCategory userCategory = UserCategory.builder()
                    .user(user)
                    .category(category)
                    .build();
            userCategoryRepository.save(userCategory);
        }

    }

    // 아이디 중복 검사
    public void isUserIdExist(String user_id) {
        User user = this.userRepository.findByUserId(user_id);
        if (user != null) {
            throw new ConflictException(ErrorCode.ID_ALREADY_EXISTS);
        }
    }

    // 로그인
    public void login(LoginDto loginDto, HttpServletResponse response) {

        User user = this.userRepository.findByUserId(loginDto.getId());
        if(user == null) {
            throw new NotFoundException(ErrorCode.USER_NOT_FOUND);
        }

        if (!passwordHashEncryption.matches(loginDto.getPassword(), user.getUserPw())) {
            throw new UnauthorizedException(ErrorCode.UNAUTHORIZED_USER);
        }

        String payload = user.getId().toString();
        String accessToken = jwtTokenProvider.createToken(payload);
        ResponseCookie cookie = ResponseCookie.from("AccessToken", JwtEncoder.encodeJwtToken(accessToken))
                .maxAge(Duration.ofMillis(1800000))
                .httpOnly(true)
                .sameSite("None").secure(true)
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    // 로그아웃
    public void logout(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("AccessToken", null)
                .maxAge(0)
                .httpOnly(true)
                .sameSite("None").secure(true)
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

}
