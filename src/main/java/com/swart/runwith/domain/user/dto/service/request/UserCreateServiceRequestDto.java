package com.swart.runwith.domain.user.dto.service.request;

import com.swart.runwith.enums.Gender;

public record UserCreateServiceRequestDto(
    String email,
    String password,
    String name,
    String phone,
    Gender gender,
    float height,
    float weight
) {

}
