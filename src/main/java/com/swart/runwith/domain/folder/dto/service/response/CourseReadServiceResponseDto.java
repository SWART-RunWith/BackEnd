package com.swart.runwith.domain.folder.dto.service.response;

import lombok.Builder;

@Builder
public record CourseReadServiceResponseDto(
    Long id,
    String title,
    int time,
    int distance
) {

}
