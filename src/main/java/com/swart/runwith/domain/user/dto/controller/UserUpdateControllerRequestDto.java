package com.swart.runwith.domain.user.dto.controller;

import com.swart.runwith.enums.Gender;

public record UserUpdateControllerRequestDto(
    String name,
    String introduction,
    String profileImageUrl,
    Gender gender,
    float height,
    float weight
) {

}
