package com.swart.runwith.sample.test.dto.service.response;

import java.util.List;

public record TestAllReadServiceResponseDto(
    List<TestReadServiceResponseDto> testReadServiceResponseDtoList
) {

}
