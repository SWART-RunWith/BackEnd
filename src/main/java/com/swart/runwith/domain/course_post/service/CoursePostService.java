package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.user.entity.Auth;

public interface CoursePostService {

    void createCoursePost(
        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );
}
