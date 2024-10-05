package org.myongjithon.onlybook.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //BadRequestException
    PATTERN("4001","형식에 맞지 않습니다."),
    NOT_BLANK("4002", "필수값이 공백입니다."),
    LENGTH("4003", "길이가 유효하지 않습니다."),

    //AuthorizedException
    COOKIE_NOT_FOUND("4010", "쿠키를 찾을 수 없습니다."),
    INVALID_TOKEN("4011", "유효하지 않은 토큰입니다."),
    INVALID_PASSWORD("4012","검증되지 않은 비밀번호입니다."),
    UNAUTHORIZED_USER("4013", "로그인 정보가 틀렸습니다."),


    //ForbiddenException


    //NotFoundException
    USER_NOT_FOUND("4040","존재하지 않는 사용자 입니다"),
    NOT_FOUND_CATEGORY("4041", "존재하지 않는 카테고리 입니다"),
    NOT_FOUND_BOOK("4042", "존재하지 않는 책입니다."),



    //ConflictException
    ID_ALREADY_EXISTS("4091", "이미 존재하는 아이디입니다.");

    //InternetException


    private final String code;
    private final String message;

    public static ErrorCode resolveValidationErrorCode(String code){
        return switch (code){
            case "NotBlank" -> NOT_BLANK;
            case "Length" -> LENGTH;
            case "Pattern" -> PATTERN;
            default -> throw new IllegalArgumentException("Unexpected value: "+ code);
        };
    }
}
