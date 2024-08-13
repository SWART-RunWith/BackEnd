package com.swart.runwith.domain.user.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
    // 400
    DUPLICATE_PHONE(BAD_REQUEST, "이미 존재하는 전화번호입니다."),
    DUPLICATE_EMAIL(BAD_REQUEST, "이미 존재하는 이메일입니다."),
    INVALID_EMAIL(BAD_REQUEST, "잘못된 이메일입니다."),
    INVALID_PASSWORD(BAD_REQUEST, "잘못된 비밀번호입니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
