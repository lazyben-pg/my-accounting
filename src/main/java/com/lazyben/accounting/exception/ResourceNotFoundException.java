package com.lazyben.accounting.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ServiceException {
    public ResourceNotFoundException(String message) {
        super(message);
        this.setErrorCode(ErrorCode.RESOURCE_NOT_FOUND);
        this.setErrorType(ErrorType.CLIENT);
        this.setStatusCode(HttpStatus.NOT_FOUND.value());
        this.setMessage(message);
    }
}
