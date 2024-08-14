package com.swart.runwith.domain.user.exception;

import com.swart.runwith.global.exception.CustomException;

public class UserException extends CustomException {

    public UserException(final UserErrorCode errorCode) {
        super(errorCode);
    }
}
