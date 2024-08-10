package com.swart.runwith.sample.test.service;

import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestAllReadServiceResponseDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;

public interface TestService {

    void createTest(final TestCreateServiceRequestDto serviceRequestDto);

    TestReadServiceResponseDto readTest(final Long testId);

    TestAllReadServiceResponseDto readAllTest();

    void updateTest(
        final Long testId,
        final TestUpdateServiceRequestDto serviceRequestDto
    );

    void deleteTest(final Long testId);
}
