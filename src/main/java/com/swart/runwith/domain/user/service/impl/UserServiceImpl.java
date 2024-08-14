package com.swart.runwith.domain.user.service.impl;

import com.swart.runwith.domain.user.dto.service.request.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserLoginServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserUpdateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.response.UserLoginServiceResponseDto;
import com.swart.runwith.domain.user.dto.service.response.UserReadServiceResponseDto;
import com.swart.runwith.domain.user.entity.Auth;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.mapper.UserEntityMapper;
import com.swart.runwith.domain.user.repository.AuthRepository;
import com.swart.runwith.domain.user.repository.UserRepository;
import com.swart.runwith.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // repository
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    // mapper
    private final UserEntityMapper userEntityMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signup(final UserCreateServiceRequestDto serviceRequestDto) {
        // 휴대전화 중복 검사
        userRepository.findByPhone(serviceRequestDto.phone())
            .ifPresent(u -> {
                throw new UserException(UserErrorCode.DUPLICATE_PHONE);
            });

        // 이메일 중복 검사
        authRepository.findByEmail(serviceRequestDto.email())
            .ifPresent(a -> {
                throw new UserException(UserErrorCode.DUPLICATE_EMAIL);
            });

        // 회원 정보 및 회원 계정 저장
        UserInfo userInfo = userRepository.save(userEntityMapper.toUserInfo(serviceRequestDto));
        Auth auth = Auth.builder()
            .email(serviceRequestDto.email())
            .password(passwordEncoder.encode(serviceRequestDto.password()))
            .userInfo(userInfo)
            .build();
        authRepository.save(auth);
    }

    @Override
    @Transactional
    public UserLoginServiceResponseDto login(final UserLoginServiceRequestDto serviceRequestDto) {
        // 이메일 검증
        Auth auth = getAuthByEmail(serviceRequestDto.email());

        // 비밀번호 검증
        if (!passwordEncoder.matches(
            serviceRequestDto.password(),
            auth.getPassword())
        ) {
            throw new UserException(UserErrorCode.INVALID_PASSWORD);
        }

        return new UserLoginServiceResponseDto(auth.getUserInfo().getId());
    }

    @Override
    @Transactional
        final Long userId,
    public void update(
        final UserUpdateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = findById(userId);
        userInfo.updateUser(serviceRequestDto);
    }

    @Override
    @Transactional
        UserInfo userInfo = findById(userId);
    public void delete(
        Auth auth = getAuthByUserInfo(userInfo);

        authRepository.delete(auth);
        userRepository.delete(userInfo);
    }

    @Override
    @Transactional(readOnly = true)
        UserInfo userInfo = findById(userId);
    public UserReadServiceResponseDto read(

        // TO DO : 러닝화 조회 로직 추가

        return userEntityMapper.toUserReadServiceResponseDto(userInfo);
    }

    private Auth getAuthByUserInfo(final UserInfo userInfo) {
        return authRepository.findByUserInfo(userInfo)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH));
    }

    private UserInfo findById(final Long userId) {
        return userRepository.findById(userId)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_USER));
    }

    private Auth getAuthByEmail(final String email) {
        return authRepository.findByEmail(email)
            .orElseThrow(() -> new UserException(UserErrorCode.INVALID_EMAIL));
    }
}
