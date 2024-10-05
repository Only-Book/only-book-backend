package org.myongjithon.onlybook.domain.user.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.authentication.PasswordHashEncryption;
import org.myongjithon.onlybook.domain.bookcase.entity.Bookcase;
import org.myongjithon.onlybook.domain.bookcase.entity.BookcaseRepository;
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
import org.myongjithon.onlybook.exception.errorcode.ErrorCode;
import org.springframework.stereotype.Service;

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

    // 회원 가입
    public void createUser(CreateUserDto createUserDto) {
        // 아이디 중복 검사


        String encryptedPassword = this.passwordHashEncryption.encrypt(createUserDto.getPassword());
        List<Comment> comments = new ArrayList<>();

        // 유저 생성
        User user = User.builder()
                .user_id(createUserDto.getId())
                .nickname(createUserDto.getNickname())
                .user_pw(encryptedPassword)
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

    // 로그인
    public void login(LoginDto loginDto, HttpServletResponse response) {

    }

    // 로그아웃
    public void logout(HttpServletResponse response) {

    }

}
