package com.swart.runwith.domain.bookmark.exception;

import com.swart.runwith.global.exception.CustomException;

public class BookmarkException extends CustomException {

    public BookmarkException(final BookmarkErrorCode errorCode) {
        super(errorCode);
    }
}
