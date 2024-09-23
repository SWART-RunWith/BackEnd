package com.swart.runwith.domain.running_data.exception;

import com.swart.runwith.global.exception.CustomException;

public class RunningDataException extends CustomException {
    
    public RunningDataException(final RunningDataErrorCode errorCode) {
        super(errorCode);
    }
}
