package com.swart.runwith.domain.running_data.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.running_data.dto.controller.RunningDataCreateControllerRequestDto;
import com.swart.runwith.domain.running_data.dto.controller.RunningDataUpdateControllerRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface RunningDataDtoMapper {
    
    RunningDataCreateServiceRequestDto toRunningDataCreateServiceRequestDto(
        RunningDataCreateControllerRequestDto requestDto
    );
    
    RunningDataUpdateServiceRequestDto toRunningDataUpdateServiceRequestDto(
        RunningDataUpdateControllerRequestDto requestDto
    );
}
