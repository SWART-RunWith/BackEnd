package com.swart.runwith.domain.running_shoes.exception;

import com.swart.runwith.global.exception.CustomException;

public class RunningShoesException extends CustomException {

    public RunningShoesException(final RunningShoesErrorCode errorCode) {
        super(errorCode);
    }
}
