package com.lazyben.accounting.exception;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorResponse> handleResourceNotFoundException(ServiceException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(ErrorResponse.builder()
                                                .statusCode(ex.getStatusCode())
                                                .errorCode(ex.getErrorCode())
                                                .message(ex.getMessage())
                                                .errorType(ex.getErrorType())
                                                .build());
    }
}
