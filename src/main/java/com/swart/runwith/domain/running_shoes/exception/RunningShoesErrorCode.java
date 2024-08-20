package com.swart.runwith.domain.running_shoes.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RunningShoesErrorCode implements ErrorCode {
    // 403
    FORBIDDEN_RUNNING_SHOES(HttpStatus.FORBIDDEN, "러닝화 정보 접근 권한이 없습니다"),
    
    // 404
    NOT_FOUND_RUNNING_SHOES(HttpStatus.NOT_FOUND, "러닝화 정보를 찾을 수 없습니다"),
    ;

    private final HttpStatus status;
    private final String message;
}
