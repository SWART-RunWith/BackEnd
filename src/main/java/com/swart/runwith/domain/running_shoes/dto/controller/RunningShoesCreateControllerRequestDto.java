package com.swart.runwith.domain.running_shoes.dto.controller;

import jakarta.validation.constraints.NotNull;

public record RunningShoesCreateControllerRequestDto(
    @NotNull
    String nickname,
    @NotNull
    String brand,
    @NotNull
    String model
) {

}
