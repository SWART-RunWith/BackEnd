package com.swart.runwith.domain.bookmark.controller;

import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.bookmark.dto.controller.PostBookmarkCreateControllerRequestDto;
import com.swart.runwith.domain.bookmark.dto.service.request.PostBookmarkCreateServiceRequestDto;
import com.swart.runwith.domain.bookmark.mapper.BookmarkDtoMapper;
import com.swart.runwith.domain.bookmark.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    // service
    private final BookmarkService bookmarkService;

    // mapper
    private final BookmarkDtoMapper bookmarkDtoMapper;

    /**
     * 공통
     */

    /**
     * 코스 공유글 북마크
     */
    @PostMapping("/courses/{course_id}")
    public ResponseEntity<Void> createPostBookmark(
        @PathVariable(name = "course_id") Long courseId,
        @Valid @RequestBody PostBookmarkCreateControllerRequestDto controllerRequestDto
    ) {
        PostBookmarkCreateServiceRequestDto serviceRequestDto =
            bookmarkDtoMapper.toPostBookmarkCreateServiceRequestDto(controllerRequestDto);
        bookmarkService.createPostBookmark(
            courseId,
            serviceRequestDto
        );

        return ResponseEntity
            .status(OK)
            .build();
    }

    @DeleteMapping("/courses/{course_id}")
    public ResponseEntity<Void> deletePostBookmark(
        @PathVariable(name = "course_id") Long courseId
    ) {
        bookmarkService.deletePostBookmark(courseId);

        return ResponseEntity
            .status(OK)
            .build();
    }

    /**
     * 개인 코스 북마크
     */
}
