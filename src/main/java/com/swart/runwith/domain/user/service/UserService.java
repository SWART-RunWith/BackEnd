package com.swart.runwith.domain.user.service;

import com.swart.runwith.domain.user.dto.service.request.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserLoginServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserUpdateServiceRequestDto;

public interface UserService {

    void signup(UserCreateServiceRequestDto serviceRequestDto);

    void login(UserLoginServiceRequestDto serviceRequestDto);
}
