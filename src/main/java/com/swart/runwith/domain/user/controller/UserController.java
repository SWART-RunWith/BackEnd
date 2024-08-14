package com.swart.runwith.domain.user.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.user.dto.controller.UserCreateControllerRequestDto;
import com.swart.runwith.domain.user.dto.controller.UserLoginControllerRequestDto;
import com.swart.runwith.domain.user.dto.controller.UserUpdateControllerRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserCreateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserLoginServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.request.UserUpdateServiceRequestDto;
import com.swart.runwith.domain.user.dto.service.response.UserLoginServiceResponseDto;
import com.swart.runwith.domain.user.dto.service.response.UserReadServiceResponseDto;
import com.swart.runwith.domain.user.mapper.UserDtoMapper;
import com.swart.runwith.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<Void> signup(
        @Valid @RequestBody UserCreateControllerRequestDto controllerRequestDto
    ) {
        UserCreateServiceRequestDto serviceRequestDto
            = userDtoMapper.toUserCreateServiceRequestDto(controllerRequestDto);

        userService.signup(serviceRequestDto);

        return ResponseEntity
            .status(CREATED)
            .build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginServiceResponseDto> login(
        @Valid @RequestBody UserLoginControllerRequestDto controllerRequestDto
    ) {
        UserLoginServiceRequestDto serviceRequestDto =
            userDtoMapper.toUserLoginServiceRequestDto(controllerRequestDto);

        return ResponseEntity
            .status(OK)
            .body(userService.login(serviceRequestDto));
    }

    @PutMapping("/users")
    public ResponseEntity<Void> update(
//        Auth userDetails,
        @RequestBody UserUpdateControllerRequestDto controllerRequestDto
    ) {
        UserUpdateServiceRequestDto serviceRequestDto =
            userDtoMapper.toUserUpdateServiceRequestDto(controllerRequestDto);

        userService.update(
//            userDetails,
            serviceRequestDto
        );

        return ResponseEntity
            .status(OK)
            .build();
    }

    @DeleteMapping("/users")
    public ResponseEntity<Void> delete(
//        Auth userDetails,
    ) {
        userService.delete(
//            userDetails,
        );

        return ResponseEntity
            .status(OK)
            .build();
    }

    @GetMapping("/users")
    public ResponseEntity<UserReadServiceResponseDto> read(
//        Auth userDetails,
    ) {
        return ResponseEntity
            .status(OK)
            .body(userService.read(
//                userDetails,
            ));
    }
}
