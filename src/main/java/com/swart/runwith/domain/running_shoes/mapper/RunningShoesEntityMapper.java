package com.swart.runwith.domain.running_shoes.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.response.RunningShoesReadServiceResponseDto;
import com.swart.runwith.domain.running_shoes.entity.RunningShoes;
import com.swart.runwith.domain.user.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface RunningShoesEntityMapper {

    RunningShoes toRunningShoes(
        RunningShoesCreateServiceRequestDto serviceRequestDto,
        UserInfo userInfo
    );

    RunningShoesReadServiceResponseDto toRunningShoesReadServiceResponseDto(
        RunningShoes runningShoes
    );
}
