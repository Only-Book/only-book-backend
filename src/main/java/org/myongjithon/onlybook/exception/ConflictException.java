package org.myongjithon.onlybook.exception;


import org.myongjithon.onlybook.exception.errorcode.ErrorCode;

public class ConflictException extends CustomException{
    public ConflictException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ConflictException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
