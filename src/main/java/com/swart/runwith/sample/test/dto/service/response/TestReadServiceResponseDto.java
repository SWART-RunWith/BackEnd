package com.swart.runwith.sample.test.dto.service.response;

import lombok.Builder;

@Builder
public record TestReadServiceResponseDto(
    Long id,
    String title,
    String field,
    String introduction
) {

}
