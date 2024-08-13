package com.swart.runwith.domain.user.dto.service;

public record UserLoginServiceRequestDto(
    String email,
    String password
) {

}
