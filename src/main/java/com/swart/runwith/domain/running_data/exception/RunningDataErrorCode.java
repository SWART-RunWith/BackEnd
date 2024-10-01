package com.swart.runwith.domain.running_data.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RunningDataErrorCode implements ErrorCode  {
    // 404
    NOT_FOUND_RUNNING_DATA(HttpStatus.NOT_FOUND, "러닝 데이터를 찾을 수 없습니다"),
    ;
    
    private final HttpStatus status;
    private final String message;
}
