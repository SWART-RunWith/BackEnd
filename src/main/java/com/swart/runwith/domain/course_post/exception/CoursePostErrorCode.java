package com.swart.runwith.domain.course_post.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum CoursePostErrorCode implements ErrorCode {
    // 404
    NOT_FOUND_COURSE_POST(HttpStatus.NOT_FOUND, "코스 공유 글을 찾을 수 없습니다."),
    ;
    private final HttpStatus status;
    private final String message;
}
