package com.lazyben.accounting.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends ServiceException {
    public InvalidParameterException(String message) {
        super(message);
        this.setErrorCode(ErrorCode.INVALID_PARAMETER);
        this.setErrorType(ErrorType.CLIENT);
        this.setStatusCode(HttpStatus.BAD_REQUEST.value());
        this.setMessage(message);
    }
}
