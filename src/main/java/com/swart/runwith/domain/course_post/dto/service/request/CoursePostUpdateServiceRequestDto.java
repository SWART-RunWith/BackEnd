package com.swart.runwith.domain.course_post.dto.service.request;

import jakarta.validation.constraints.NotNull;

public record CoursePostUpdateServiceRequestDto(
    @NotNull(message = "필수 항목 : title")
    String title,
    String content
    // TO DO : 러닝 데이터 id
) {

}
