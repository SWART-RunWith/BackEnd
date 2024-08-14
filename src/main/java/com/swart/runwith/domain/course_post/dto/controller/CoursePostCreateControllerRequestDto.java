package com.swart.runwith.domain.course_post.dto.controller;

import jakarta.validation.constraints.NotNull;

public record CoursePostCreateControllerRequestDto(
    @NotNull
    String title,
    String content
    // TO DO : 러닝 데이터 id
) {

}
