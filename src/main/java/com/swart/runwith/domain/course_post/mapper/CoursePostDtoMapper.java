package com.swart.runwith.domain.course_post.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.course_post.dto.controller.CoursePostCreateControllerRequestDto;
import com.swart.runwith.domain.course_post.dto.service.request.CoursePostCreateServiceRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface CoursePostDtoMapper {

    CoursePostCreateServiceRequestDto toCoursePostCreateServiceRequestDto(
        CoursePostCreateControllerRequestDto controllerRequestDto
    );
}
