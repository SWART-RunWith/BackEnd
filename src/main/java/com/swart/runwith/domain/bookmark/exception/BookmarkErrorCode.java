package com.swart.runwith.domain.bookmark.exception;

import com.swart.runwith.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BookmarkErrorCode implements ErrorCode {
    // 400
    ALREADY_BOOKMARK(HttpStatus.BAD_REQUEST, "이미 북마크한 글입니다."),

    // 404
    NOT_FOUND_BOOKMARK(HttpStatus.NOT_FOUND, "존재하지 않는 북마크입니다.");

    private final HttpStatus status;
    private final String message;
}
