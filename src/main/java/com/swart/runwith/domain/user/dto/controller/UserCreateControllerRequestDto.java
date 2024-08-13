package com.swart.runwith.domain.user.dto.controller;

import com.swart.runwith.enums.Gender;
import jakarta.validation.constraints.NotNull;

public record UserCreateControllerRequestDto(
    @NotNull
    String email,
    @NotNull
    String password,
    @NotNull
    String name,
    @NotNull
    String phone,
    @NotNull
    Gender gender,
    float height,
    float weight
) {

}
