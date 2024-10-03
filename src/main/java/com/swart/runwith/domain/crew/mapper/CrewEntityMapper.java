package com.swart.runwith.domain.crew.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.crew.entity.Crew;
import com.swart.runwith.domain.crew.response.CrewUserReadServiceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface CrewEntityMapper {

    CrewUserReadServiceResponseDto toCrewUserReadServiceResponseDto(
        Crew crew
    );
}
