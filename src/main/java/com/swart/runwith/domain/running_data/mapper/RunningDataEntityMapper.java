package com.swart.runwith.domain.running_data.mapper;

import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.response.RunningDataReadServiceResponseDto;
import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.user.entity.UserInfo;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RunningDataEntityMapper {
    RunningData toRunningData(
        RunningDataCreateServiceRequestDto serviceRequestDto,
        UserInfo userInfo
    );
    
    RunningDataReadServiceResponseDto toRunningDataReadServiceResponseDto(
        RunningData runningData
    );
}
