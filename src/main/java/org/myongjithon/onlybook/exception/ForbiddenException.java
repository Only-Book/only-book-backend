package org.myongjithon.onlybook.exception;


import org.myongjithon.onlybook.exception.errorcode.ErrorCode;

public class ForbiddenException extends CustomException{
    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ForbiddenException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
