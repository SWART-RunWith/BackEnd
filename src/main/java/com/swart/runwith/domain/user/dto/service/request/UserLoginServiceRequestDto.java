package com.swart.runwith.domain.user.dto.service.request;

public record UserLoginServiceRequestDto(
    String email,
    String password
) {

}
