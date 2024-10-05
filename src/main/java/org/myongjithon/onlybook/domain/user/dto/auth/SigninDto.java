package org.myongjithon.onlybook.domain.user.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SigninDto {

    //아이디
    @NotBlank(message = "아이디를 입력해주세요.")
    private String id;

    //비밀번호
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

}
