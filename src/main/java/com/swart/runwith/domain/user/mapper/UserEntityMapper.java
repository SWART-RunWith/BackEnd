package com.swart.runwith.domain.user.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface UserEntityMapper {

    UserInfo toUserInfo(
        UserCreateServiceRequestDto serviceRequestDto
    );
}
