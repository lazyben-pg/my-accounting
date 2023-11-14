package com.lazyben.accounting.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceException extends RuntimeException {

    private String message;
    private ErrorCode errorCode;
    private int statusCode;
    private ErrorType errorType;

    public enum ErrorType {
        CLIENT,
        SERVER,
        UNKNOWN
    }

    public ServiceException(String message) {
        super(message);
    }
}
