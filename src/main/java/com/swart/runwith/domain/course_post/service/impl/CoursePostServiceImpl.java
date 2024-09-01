package com.swart.runwith.domain.course_post.service.impl;

import com.swart.runwith.domain.course_post.dto.service.request.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.request.CoursePostUpdateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;
import com.swart.runwith.domain.course_post.entity.CoursePost;
import com.swart.runwith.domain.course_post.exception.CoursePostErrorCode;
import com.swart.runwith.domain.course_post.exception.CoursePostException;
import com.swart.runwith.domain.course_post.mapper.CoursePostEntityMapper;
import com.swart.runwith.domain.course_post.repository.CoursePostRepository;
import com.swart.runwith.domain.course_post.service.CoursePostService;
import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void create(
//        final Auth userDetails,
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

    @Override
    @Transactional(readOnly = true)
    public CoursePostReadServiceResponseDto read(final Long courseId) {
        CoursePost coursePost = getCoursePostById(courseId);

        return coursePostEntityMapper.toCoursePostReadServiceResponseDto(
            coursePost,
            coursePost.getUserInfo().getName()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoursePostReadServiceResponseDto> readAll() {
        return coursePostRepository
            .findAll()
            .stream()
            .map(coursePost -> coursePostEntityMapper.toCoursePostReadServiceResponseDto(
                coursePost,
                coursePost.getUserInfo().getName()
            )).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoursePostReadServiceResponseDto> readMine(
//        Auth userDetails,
    ) {
        UserInfo userInfo = testUserInfo();

        return coursePostRepository
            .findByUserInfo(userInfo)
            .stream()
            .map(coursePost -> coursePostEntityMapper.toCoursePostReadServiceResponseDto(
                coursePost,
                userInfo.getName()
            )).toList();
    }

    @Override
    @Transactional
    public void update(
        final Long courseId,
        final CoursePostUpdateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();
        CoursePost coursePost = getCoursePostById(courseId);

        validAuthority(
            userInfo,
            coursePost
        );

        coursePost.update(serviceRequestDto);
    }

    @Override
    @Transactional
    public void delete(final Long courseId) {
        UserInfo userInfo = testUserInfo();
        CoursePost coursePost = getCoursePostById(courseId);

        validAuthority(
            userInfo,
            coursePost
        );

        coursePostRepository.delete(coursePost);
    }

    private void validAuthority(
        final UserInfo userInfo,
        final CoursePost coursePost
    ) {
        if (!coursePost.getUserInfo().equals(userInfo)) {
            throw new CoursePostException(CoursePostErrorCode.UNAUTHORIZED);
        }
    }

    private CoursePost getCoursePostById(final Long courseId) {
        return coursePostRepository.findById(courseId)
            .orElseThrow(() -> new CoursePostException(CoursePostErrorCode.NOT_FOUND_COURSE_POST));
    }
}
