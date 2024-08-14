package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;

public interface CoursePostService {

    void create(
//        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );

    CoursePostReadServiceResponseDto read(Long courseId);
}
