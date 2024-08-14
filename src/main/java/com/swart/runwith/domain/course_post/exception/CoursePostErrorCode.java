package com.swart.runwith.domain.course_post.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CoursePostErrorCode implements ErrorCode {
    ;
    private final HttpStatus status;
    private final String message;
}
