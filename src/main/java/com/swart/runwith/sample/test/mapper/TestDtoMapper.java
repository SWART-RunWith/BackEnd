package com.swart.runwith.sample.test.mapper;

import com.swart.runwith.sample.test.dto.controller.TestCreateControllerRequestDto;
import com.swart.runwith.sample.test.dto.controller.TestUpdateControllerRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TestDtoMapper {

    TestCreateServiceRequestDto toTestCreateServiceRequestDto(
        TestCreateControllerRequestDto controllerRequestDto
    );

    TestUpdateServiceRequestDto toTestUpdateServiceRequestDto(
        TestUpdateControllerRequestDto controllerRequestDto
    );
}
