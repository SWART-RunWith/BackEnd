package com.swart.runwith.domain.user.dto.service.response;

import com.swart.runwith.enums.Gender;

public record UserReadServiceResponseDto(
    String name,
    String introduction,
    String profileImageUrl,
    String phone,
    Gender gender,
    float height,
    float weight
    // 러닝화, 최고 기록 관련 정보 추가
) {

}
