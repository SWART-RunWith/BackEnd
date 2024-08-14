package com.swart.runwith.domain.course_post.service.impl;

import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.course_post.mapper.CoursePostEntityMapper;
import com.swart.runwith.domain.course_post.repository.CoursePostRepository;
import com.swart.runwith.domain.course_post.service.CoursePostService;
import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursePostServiceImpl implements CoursePostService {

    // repository
    private final AuthRepository authRepository;
    private final CoursePostRepository coursePostRepository;

    // mapper
    private final CoursePostEntityMapper coursePostEntityMapper;

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
    public void createCoursePost(
        final Auth userDetails,
        final CoursePostCreateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();
        CoursePost coursePost = CoursePost.builder()
            .title(serviceRequestDto.title())
            .content(serviceRequestDto.content())
            .userInfo(userInfo)
            .build();
        coursePostRepository.save(coursePost);
    }
}
