package com.swart.runwith.domain.course_post.dto.service.response;

import lombok.Builder;

@Builder
public record CoursePostReadServiceResponseDto(
    Long id,
    String title,
    String content,
    Long likeCount,
    String name
    // TO DO : 러닝 데이터 추가
) {

}
