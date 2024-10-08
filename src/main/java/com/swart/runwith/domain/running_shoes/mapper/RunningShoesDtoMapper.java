package com.swart.runwith.domain.running_shoes.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.running_shoes.dto.controller.RunningShoesCreateControllerRequestDto;
import com.swart.runwith.domain.running_shoes.dto.controller.RunningShoesUpdateControllerRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesUpdateServiceRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface RunningShoesDtoMapper {

    RunningShoesCreateServiceRequestDto toRunningShoesCreateServiceRequestDto(
        RunningShoesCreateControllerRequestDto controllerRequestDto
    );

    RunningShoesUpdateServiceRequestDto toRunningShoesUpdateServiceRequestDto(
        RunningShoesUpdateControllerRequestDto controllerRequestDto
    );
}
