package com.swart.runwith.domain.bookmark.controller;

import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/courses/{course_id}/bookmark")
    public ResponseEntity<?> create(
        @PathVariable(name = "course_id") Long courseId
    ) {
        bookmarkService.create(courseId);

        return ResponseEntity
            .status(OK)
            .build();
    }
}
