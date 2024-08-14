package com.swart.runwith.domain.user.service;

import com.swart.runwith.domain.user.dto.service.request.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserLoginServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserUpdateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.response.UserLoginServiceResponseDto;
import com.swart.runwith.domain.user.dto.service.response.UserReadServiceResponseDto;

public interface UserService {

    void signup(UserCreateServiceRequestDto serviceRequestDto);

    UserLoginServiceResponseDto login(UserLoginServiceRequestDto serviceRequestDto);

    void updateUser(
        Long memberId,
        UserUpdateServiceRequestDto serviceRequestDto
    );

    void deleteUser(Long userId);

    UserReadServiceResponseDto readUser(Long userId);
}
