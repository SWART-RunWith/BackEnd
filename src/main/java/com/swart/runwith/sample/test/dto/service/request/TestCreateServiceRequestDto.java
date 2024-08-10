package com.swart.runwith.sample.test.dto.service.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record TestCreateServiceRequestDto(
    @NotNull
    String field,
    @NotNull
    String title,
    @NotNull
    String introduction
) {

}