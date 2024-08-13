package com.swart.runwith.domain.user.dto.controller;

import jakarta.validation.constraints.NotNull;

public record UserLoginControllerRequestDto(
    @NotNull
    String email,
    @NotNull
    String password
) {

}
