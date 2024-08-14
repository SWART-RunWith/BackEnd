package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;
import java.util.List;

public interface CoursePostService {

    void create(
//        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );

    CoursePostReadServiceResponseDto read(Long courseId);

    List<CoursePostReadServiceResponseDto> readAll();
}
