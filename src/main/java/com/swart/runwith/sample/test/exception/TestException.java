package com.swart.runwith.sample.test.exception;

import com.swart.runwith.global.exception.CustomException;
import lombok.Getter;

@Getter
public class TestException extends CustomException {

    public TestException(final TestErrorCode errorCode) {
        super(errorCode);
    }
}
