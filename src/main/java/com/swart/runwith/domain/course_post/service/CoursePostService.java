package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;

public interface CoursePostService {

    void create(
//        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );
}
