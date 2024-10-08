package org.myongjithon.onlybook.domain.user.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginDto {

    //아이디
    @NotBlank(message = "사용하실 아이디(이메일)을 입력해주세요.")
    private String id;

    //비밀번호
    @NotBlank(message = "영문과 숫자,특수기호를 조합하여 8~14글자 미만으로 입력하여 주세요.")
    private String password;
}
