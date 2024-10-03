package com.swart.runwith.domain.crew.response;

import lombok.Builder;

@Builder
public record CrewReadServiceResponseDto(
    Long id,
    String name,
    String location,
    int count,
    String ruleTitle,
    String ruleContent
) {

}
