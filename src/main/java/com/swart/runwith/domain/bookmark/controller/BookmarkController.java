package com.swart.runwith.domain.bookmark.controller;

import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    /**
     * 공통
     */

    /**
     * 코스 공유글 북마크
     */
    @PostMapping("/courses/{course_id}")
    public ResponseEntity<Void> createPostBookmark(
        @PathVariable(name = "course_id") Long courseId
    ) {
        bookmarkService.createPostBookmark(courseId);

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
