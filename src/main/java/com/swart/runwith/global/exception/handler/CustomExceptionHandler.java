package com.swart.runwith.global.exception.handler;

import com.swart.runwith.global.exception.CustomException;
import com.swart.runwith.global.exception.CustomExceptionResponse;
import com.swart.runwith.global.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomExceptionResponse> customExceptionHandler(
        CustomException exception
    ) {
        ErrorCode errorCode = exception.getErrorCode();
        log.error(
            "커스텀 예외 {} {}: {}",
            exception.getClass().getSimpleName(),
            errorCode.name(),
            errorCode.getMessage()
        );

        return ResponseEntity
            .status(errorCode.getStatus())
            .body(
                CustomExceptionResponse.builder()
                    .status(errorCode.getStatus().value())
                    .name(errorCode.name())
                    .message(errorCode.getMessage())
                    .build()
            );
    }
}
