package com.swart.runwith.sample.test.service;

import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;
import java.util.List;

public interface TestService {

    void create(final TestCreateServiceRequestDto serviceRequestDto);

    TestReadServiceResponseDto read(final Long testId);

    List<TestReadServiceResponseDto> readAll();

    void update(
        final Long testId,
        final TestUpdateServiceRequestDto serviceRequestDto
    );

    void delete(final Long testId);
}
