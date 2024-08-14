package com.swart.runwith.domain.course_post.dto.service.response;

import java.util.List;

public record CoursePostReadAllServiceResponseDto(
    List<CoursePostReadServiceResponseDto> coursePostReadServiceResponseDtoList
) {

}
