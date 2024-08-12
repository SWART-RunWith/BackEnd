package com.swart.runwith.sample.test.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum TestErrorCode implements ErrorCode {
    NOT_FOUND_TEST(HttpStatus.NOT_FOUND, "존재하지 않은 test"),
    ;

    private final HttpStatus status;
    private final String message;
}
