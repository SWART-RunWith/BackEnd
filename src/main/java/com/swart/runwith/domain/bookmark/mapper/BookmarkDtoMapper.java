package com.swart.runwith.domain.bookmark.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.bookmark.dto.controller.PostBookmarkCreateControllerRequestDto;
import com.swart.runwith.domain.bookmark.dto.service.request.PostBookmarkCreateServiceRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface BookmarkDtoMapper {

    PostBookmarkCreateServiceRequestDto toPostBookmarkCreateServiceRequestDto(
        PostBookmarkCreateControllerRequestDto requestDto
    );
}
