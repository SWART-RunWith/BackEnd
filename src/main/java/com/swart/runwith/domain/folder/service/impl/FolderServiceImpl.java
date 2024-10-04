package com.swart.runwith.domain.folder.service.impl;

import com.swart.runwith.domain.bookmark.repository.CourseBookmarkRepository;
import com.swart.runwith.domain.folder.dto.service.response.CourseReadServiceResponseDto;
import com.swart.runwith.domain.folder.dto.service.response.FolderReadServiceResponseDto;
import com.swart.runwith.domain.folder.entity.Folder;
import com.swart.runwith.domain.folder.mapper.FolderEntityMapper;
import com.swart.runwith.domain.folder.repository.FolderRepository;
import com.swart.runwith.domain.folder.service.FolderService;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {

    private final FolderRepository folderRepository;
    private final CourseBookmarkRepository courseBookmarkRepository;
    private final AuthRepository authRepository;

    private final FolderEntityMapper folderEntityMapper;

    private UserInfo testUserInfo() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH)).getUserInfo();
    }

    @Override
    @Transactional(readOnly = true)
    public List<FolderReadServiceResponseDto> getAll() {
        List<Folder> FolderList = folderRepository.findByUserInfo(testUserInfo());

        return FolderList.stream()
            .map(folderEntityMapper::toFolderReadServiceResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseReadServiceResponseDto> getAllCourse(final Long folderId) {
        Folder folder = folderRepository.findById(folderId)
            .orElseThrow(() -> new RuntimeException(""));

        return courseBookmarkRepository.findByFolder(folder).stream().map(
            courseBookmark -> {
                return CourseReadServiceResponseDto.builder()
                    .id(courseBookmark.getId())
                    .time(courseBookmark.getRunningData().getTime())
                    .distance(courseBookmark.getRunningData().getDistance())
                    .title(courseBookmark.getTitle())
                    .build();
            }
        ).collect(Collectors.toList());
    }
}
