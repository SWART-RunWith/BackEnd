package com.swart.runwith.domain.user.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.swart.runwith.domain.user.dto.controller.UserCreateControllerRequestDto;
import com.swart.runwith.domain.user.dto.service.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.mapper.UserDtoMapper;
import com.swart.runwith.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    // service
    private final UserService userService;

    // mapper
    private final UserDtoMapper userDtoMapper;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(
        @Valid @RequestBody UserCreateControllerRequestDto controllerRequestDto
    ) {
        UserCreateServiceRequestDto serviceRequestDto
            = userDtoMapper.toUserCreateServiceRequestDto(controllerRequestDto);

        userService.signup(serviceRequestDto);

        return ResponseEntity
            .status(CREATED)
            .build();
    }

}
