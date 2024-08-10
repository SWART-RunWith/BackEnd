package com.swart.runwith.sample.test.mapper;

import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;
import com.swart.runwith.sample.test.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TestEntityMapper {

    Test toTest(
        TestCreateServiceRequestDto testCreateServiceRequestDto
    );

    TestReadServiceResponseDto toTestReadServiceResponseDto(
        Test test
    );
}
