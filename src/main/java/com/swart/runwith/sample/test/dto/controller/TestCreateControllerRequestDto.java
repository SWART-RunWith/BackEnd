package com.swart.runwith.sample.test.dto.controller;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record TestCreateControllerRequestDto(
    @NotNull
    String field,
    @NotNull
    String title,
    @NotNull
    String introduction
) {

}
