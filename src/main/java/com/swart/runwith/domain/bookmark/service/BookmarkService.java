package com.swart.runwith.domain.bookmark.service;

import com.swart.runwith.domain.bookmark.dto.service.request.PostBookmarkCreateServiceRequestDto;

public interface BookmarkService {

    void createPostBookmark(
        Long courseId,
        PostBookmarkCreateServiceRequestDto serviceRequestDto
    );

    void deletePostBookmark(Long courseId);
}
