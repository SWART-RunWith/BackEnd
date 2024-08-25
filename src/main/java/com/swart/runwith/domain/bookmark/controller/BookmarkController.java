package com.swart.runwith.domain.bookmark.controller;

import com.swart.runwith.domain.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;
}
