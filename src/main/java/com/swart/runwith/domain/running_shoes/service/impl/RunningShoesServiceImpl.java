package com.swart.runwith.domain.running_shoes.service.impl;

import com.swart.runwith.domain.running_shoes.mapper.RunningShoesEntityMapper;
import com.swart.runwith.domain.running_shoes.repository.RunningShoesRepository;
import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunningShoesServiceImpl implements RunningShoesService {

    // repository
    private final RunningShoesRepository runningShoesRepository;
    private final AuthRepository authRepository;

    // mapper
    private final RunningShoesEntityMapper runningShoesEntityMapper;

    // token 작성 전 test 용 user info 및 auth 반환 method
    private UserInfo testUserInfo() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH)).getUserInfo();
    }
}
