package com.swart.runwith.domain.user.service;

import com.swart.runwith.domain.user.dto.service.request.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserLoginServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserUpdateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.response.UserLoginServiceResponseDto;

public interface UserService {

    void signup(UserCreateServiceRequestDto serviceRequestDto);

    UserLoginServiceResponseDto login(UserLoginServiceRequestDto serviceRequestDto);
}
