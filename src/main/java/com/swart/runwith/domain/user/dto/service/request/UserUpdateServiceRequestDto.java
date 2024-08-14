package com.swart.runwith.domain.user.dto.service.request;

import com.swart.runwith.enums.Gender;

public record UserUpdateServiceRequestDto(
    String name,
    String introduction,
    String profileImageUrl,
    Gender gender,
    float height,
    float weight
) {

}
