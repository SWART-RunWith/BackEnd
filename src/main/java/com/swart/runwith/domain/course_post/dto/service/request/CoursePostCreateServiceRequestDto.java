package com.swart.runwith.domain.course_post.dto.service.request;

public record CoursePostCreateServiceRequestDto(
    String title,
    String content
    // TO DO : 러닝 데이터 id 추가
) {

}
