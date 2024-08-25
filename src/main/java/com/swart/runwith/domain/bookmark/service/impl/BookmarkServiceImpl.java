package com.swart.runwith.domain.bookmark.service.impl;

import com.swart.runwith.domain.bookmark.repository.BookmarkRepository;
import com.swart.runwith.domain.bookmark.service.BookmarkService;
import com.swart.runwith.domain.user.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final AuthRepository authRepository;
    private final BookmarkRepository bookmarkRepository;
}
