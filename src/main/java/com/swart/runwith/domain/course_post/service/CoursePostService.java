package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;

public interface CoursePostService {

    void createCoursePost(
//        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );
}
