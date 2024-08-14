package com.swart.runwith.sample.test.dto.controller;

import jakarta.validation.constraints.NotNull;

public record TestCreateControllerRequestDto(
    @NotNull
    String field,
    @NotNull
    String title,
    @NotNull
    String introduction
) {

}
