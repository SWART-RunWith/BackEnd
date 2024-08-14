package com.swart.runwith.domain.course_post.service.impl;

import com.swart.runwith.domain.course_post.service.CoursePostService;
import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursePostServiceImpl implements CoursePostService {

    private final AuthRepository authRepository;

    // token 작업 전에 사용할 test auth & user
    // userDetails 대신 testAuth 사용
    private Auth testAuth() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH));
    }

    private UserInfo testUserInfo() {
        return testAuth().getUserInfo();
    }
}
