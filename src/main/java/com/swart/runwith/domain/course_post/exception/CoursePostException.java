package com.swart.runwith.domain.course_post.exception;

import com.swart.runwith.global.exception.CustomException;

public class CoursePostException extends CustomException {

    public CoursePostException(final CoursePostErrorCode errorCode) {
        super(errorCode);
    }
}
