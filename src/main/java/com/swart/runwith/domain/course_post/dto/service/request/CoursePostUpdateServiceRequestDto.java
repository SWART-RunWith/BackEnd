package com.swart.runwith.domain.course_post.dto.service.request;

import jakarta.validation.constraints.NotBlank;

public record CoursePostUpdateServiceRequestDto(
    @NotBlank(message = "필수 항목 : title")
    String title,
    @NotBlank(message = "필수 항목 : content")
    String content
    // TO DO : 러닝 데이터 id
) {

}
