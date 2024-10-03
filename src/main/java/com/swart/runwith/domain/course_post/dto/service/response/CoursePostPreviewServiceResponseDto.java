package com.swart.runwith.domain.course_post.dto.service.response;

import lombok.Builder;

@Builder
public record CoursePostPreviewServiceResponseDto(
    Long id,
    String title,
    int distance,
    int time,
    String content,
    String location,
    String name,
    String routeImage
) {

}
