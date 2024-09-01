package com.swart.runwith.domain.bookmark.dto.controller;

import jakarta.validation.constraints.NotBlank;

public record PostBookmarkCreateControllerRequestDto(
    @NotBlank(message = "title 입력해주세요.")
    String title
) {

}
