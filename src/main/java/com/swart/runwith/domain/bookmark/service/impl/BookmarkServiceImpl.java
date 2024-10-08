package com.swart.runwith.domain.bookmark.service.impl;

import com.swart.runwith.domain.bookmark.dto.service.request.PostBookmarkCreateServiceRequestDto;
import com.swart.runwith.domain.bookmark.entity.PostBookmark;
import com.swart.runwith.domain.bookmark.exception.BookmarkErrorCode;
import com.swart.runwith.domain.bookmark.exception.BookmarkException;
import com.swart.runwith.domain.bookmark.repository.PostBookmarkRepository;
import com.swart.runwith.domain.bookmark.service.BookmarkService;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.course_post.exception.CoursePostErrorCode;
import com.swart.runwith.domain.course_post.exception.CoursePostException;
import com.swart.runwith.domain.course_post.repository.CoursePostRepository;
import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

    private final AuthRepository authRepository;
    private final PostBookmarkRepository postBookmarkRepository;
    private final CoursePostRepository coursePostRepository;

    // token 작업 전에 사용할 test auth & user
    // userDetails 대신 testAuth 사용
    private Auth testAuth() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH));
    }

    private UserInfo testUserInfo() {
        return testAuth().getUserInfo();
    }

    @Override
    @Transactional
    public void createPostBookmark(
        final Long courseId,
        @Valid final PostBookmarkCreateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();
        CoursePost coursePost = getCoursePostById(courseId);

        checkExistBookmark(userInfo, coursePost);

        // To Do : folder 추가
        PostBookmark postBookmark = PostBookmark.builder()
            .userInfo(userInfo)
            .coursePost(coursePost)
            .title(serviceRequestDto.title())
            .build();

        postBookmarkRepository.save(postBookmark);
    }

    @Override
    @Transactional
    public void deletePostBookmark(final Long courseId) {
        UserInfo userInfo = testUserInfo();
        CoursePost coursePost = getCoursePostById(courseId);

        PostBookmark postBookmark = getBookmarkByUserInfoAndCoursePost(
            userInfo,
            coursePost
        );

        postBookmarkRepository.delete(postBookmark);
    }

    private PostBookmark getBookmarkByUserInfoAndCoursePost(
        final UserInfo userInfo,
        final CoursePost coursePost
    ) {
        return postBookmarkRepository.findByUserInfoAndCoursePost(userInfo, coursePost)
            .orElseThrow(() -> new BookmarkException(BookmarkErrorCode.NOT_FOUND_BOOKMARK));
    }

    private void checkExistBookmark(
        final UserInfo userInfo,
        final CoursePost coursePost
    ) {
        postBookmarkRepository.findByUserInfoAndCoursePost(
            userInfo,
            coursePost
        ).ifPresent(b -> {
            throw new BookmarkException(BookmarkErrorCode.ALREADY_BOOKMARK);
        });
    }

    private CoursePost getCoursePostById(final Long courseId) {
        return coursePostRepository.findById(courseId)
            .orElseThrow(() -> new CoursePostException(CoursePostErrorCode.NOT_FOUND_COURSE_POST));
    }
}
