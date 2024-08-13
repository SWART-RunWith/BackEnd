package com.swart.runwith.domain.user.service.impl;

import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;
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

    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void signup(final UserCreateServiceRequestDto serviceRequestDto) {
        // 휴대전화 중복 검사

        // 이메일 중복 검사

        // 회원 정보 및 회원 계정 저장
    }
}
