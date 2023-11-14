package com.lazyben.accounting.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private int statusCode;
    private String message;
    private ServiceException.ErrorType errorType;
    private ErrorCode errorCode;
}
