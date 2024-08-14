package com.swart.runwith.sample.test.service;

import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestAllReadServiceResponseDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;

public interface TestService {

    void create(final TestCreateServiceRequestDto serviceRequestDto);

    TestReadServiceResponseDto read(final Long testId);

    TestAllReadServiceResponseDto readAll();

    void update(
        final Long testId,
        final TestUpdateServiceRequestDto serviceRequestDto
    );

    void delete(final Long testId);
}
