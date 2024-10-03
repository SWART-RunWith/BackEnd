package com.swart.runwith.domain.course_post.service;

import com.swart.runwith.domain.course_post.dto.service.request.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.request.CoursePostUpdateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostPreviewServiceResponseDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;
import java.util.List;

public interface CoursePostService {

    void create(
//        Auth userDetails,
        CoursePostCreateServiceRequestDto serviceRequestDto
    );

    CoursePostReadServiceResponseDto read(Long courseId);

    List<CoursePostReadServiceResponseDto> readAll();

    List<CoursePostReadServiceResponseDto> readMine(
//        Auth userDetails,
    );

    void update(
        Long courseId,
        CoursePostUpdateServiceRequestDto serviceRequestDto
    );

    void delete(Long courseId);

    List<CoursePostPreviewServiceResponseDto> searchByTitle(String title);
}
