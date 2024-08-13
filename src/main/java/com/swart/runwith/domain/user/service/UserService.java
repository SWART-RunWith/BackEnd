package com.swart.runwith.domain.user.service;

import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.UserLoginServiceRequestDto;

public interface UserService {

    void signup(UserCreateServiceRequestDto serviceRequestDto);

    void login(UserLoginServiceRequestDto serviceRequestDto);
}
