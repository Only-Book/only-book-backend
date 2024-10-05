package org.myongjithon.onlybook.domain.user.dto.user;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import java.util.List;

@Getter
public class CreateUserDto {

    @NotBlank(message = "닉네임이 비어있습니다.")
    private String nickname;

    @NotBlank(message = "아이디가 비어있습니다.")
    private String id;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;

    @NotNull
    private List<Long> categoryIdList;
}
