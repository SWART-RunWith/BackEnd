package com.swart.runwith.domain.folder.service;

import com.swart.runwith.domain.folder.dto.service.response.CourseReadServiceResponseDto;
import com.swart.runwith.domain.folder.dto.service.response.FolderReadServiceResponseDto;
import java.util.List;

public interface FolderService {

    List<FolderReadServiceResponseDto> getAll();

    List<CourseReadServiceResponseDto> getAllCourse(Long folderId);
}
