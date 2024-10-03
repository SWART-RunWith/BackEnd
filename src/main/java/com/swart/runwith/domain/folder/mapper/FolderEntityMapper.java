package com.swart.runwith.domain.folder.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import com.swart.runwith.domain.folder.dto.service.response.FolderReadServiceResponseDto;
import com.swart.runwith.domain.folder.entity.Folder;
import org.mapstruct.Mapper;

@Mapper(componentModel = SPRING)
public interface FolderEntityMapper {

    FolderReadServiceResponseDto toFolderReadServiceResponseDto(Folder folder);
}
