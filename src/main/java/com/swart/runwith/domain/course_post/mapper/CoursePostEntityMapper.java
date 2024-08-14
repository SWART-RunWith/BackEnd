package com.swart.runwith.domain.course_post.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface CoursePostEntityMapper {

    CoursePostReadServiceResponseDto toCoursePostReadServiceResponseDto(
        CoursePost coursePost,
        String name
    );
}
