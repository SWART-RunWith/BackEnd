package com.swart.runwith.sample.test.dto.service.request;

import jakarta.validation.constraints.NotNull;

public record TestCreateServiceRequestDto(
    @NotNull
    String field,
    @NotNull
    String title,
    @NotNull
    String introduction
) {

}