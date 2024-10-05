package org.myongjithon.onlybook.exception;


import org.myongjithon.onlybook.exception.errorcode.ErrorCode;

public class FileStorageException extends CustomException{


    public FileStorageException(ErrorCode errorCode) {
        super(errorCode);
    }

    public FileStorageException(ErrorCode errorCode, String detail) {
        super(errorCode, detail);
    }
}
