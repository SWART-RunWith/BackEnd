package com.swart.runwith.domain.bookmark.dto.service.request;

import jakarta.validation.constraints.NotBlank;

public record PostBookmarkCreateServiceRequestDto(
    @NotBlank(message = "title 입력해주세요.")
    String title
) {

}
