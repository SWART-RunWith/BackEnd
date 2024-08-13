package com.swart.runwith.domain.user.service;

import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;

public interface UserService {

    void signup(UserCreateServiceRequestDto serviceRequestDto);
}
