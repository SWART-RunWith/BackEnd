package com.swart.runwith.domain.running_shoes.controller;

import com.swart.runwith.domain.running_shoes.dto.controller.RunningShoesCreateControllerRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.response.RunningShoesReadServiceResponseDto;
import com.swart.runwith.domain.running_shoes.mapper.RunningShoesDtoMapper;
import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoes")
@RequiredArgsConstructor
public class RunningShoesController {

    // service
    private final RunningShoesService runningShoesService;

    // mapper
    private final RunningShoesDtoMapper runningShoesDtoMapper;

    /**
     * 러닝화 생성
     *
     * @param controllerRequestDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Void> create(
//        @AuthenticationPrincipal UserDetails userDetails,
        @RequestBody RunningShoesCreateControllerRequestDto controllerRequestDto
    ) {
        RunningShoesCreateServiceRequestDto serviceRequestDto =
            runningShoesDtoMapper.toRunningShoesCreateServiceRequestDto(controllerRequestDto);

        runningShoesService.create(
//            userDetails,
            serviceRequestDto
        );

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
    }

    /**
     * 러닝화 정보 전체 조회
     *
     * @return
     */

    @GetMapping("")
    public ResponseEntity<List<RunningShoesReadServiceResponseDto>> readAll(
//        @AuthenticationPrincipal UserDetails userDetails
    ) {
        List<RunningShoesReadServiceResponseDto> serviceResponseDtoList =
            runningShoesService.readAll(
//            userDetails
            );

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(serviceResponseDtoList);
    }
}
