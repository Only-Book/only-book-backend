package org.myongjithon.onlybook.exception;


import org.myongjithon.onlybook.exception.errorcode.ErrorCode;

public class UnauthorizedException extends CustomException{
    public UnauthorizedException(ErrorCode errorCode) {
        super(errorCode);
    }

    public UnauthorizedException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
