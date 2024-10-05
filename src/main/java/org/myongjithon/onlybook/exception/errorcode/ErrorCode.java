package org.myongjithon.onlybook.exception.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    //BadRequestException
    SIZE("4000", "길이가 유효하지 않습니다."),
    PATTERN("4001","형식에 맞지 않습니다."),
    NOT_BLANK("4002", "필수값이 공백입니다.");

    //AuthorizedException


    //ForbiddenException


    //NotFoundException



    //ConflictException


    //InternetException


    private final String code;
    private final String message;

    public static ErrorCode resolveValidationErrorCode(String code){
        return switch (code){
            case "Size" -> SIZE;
            case "Pattern" -> PATTERN;
            case "NotBlank" -> NOT_BLANK;
            default -> throw new IllegalArgumentException("Unexpected value: "+ code);
        };
    }
}
