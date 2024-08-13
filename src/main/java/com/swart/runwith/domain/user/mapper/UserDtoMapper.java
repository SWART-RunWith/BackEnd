package com.swart.runwith.domain.user.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.user.dto.controller.UserCreateControllerRequestDto;
import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface UserDtoMapper {

    UserCreateServiceRequestDto toUserCreateServiceRequestDto(
        UserCreateControllerRequestDto controllerRequestDto
    );
}
