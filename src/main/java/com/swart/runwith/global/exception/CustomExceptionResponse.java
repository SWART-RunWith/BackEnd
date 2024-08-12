package com.swart.runwith.global.exception;

import lombok.Builder;

@Builder
public record CustomExceptionResponse(
    int status,
    String name,
    String message
) {

}
