package com.swart.runwith.domain.running_shoes.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.running_shoes.dto.controller.RunningShoesCreateControllerRequestDto;
import com.swart.runwith.domain.running_shoes.dto.controller.RunningShoesUpdateControllerRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesUpdateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.response.RunningShoesReadServiceResponseDto;
import com.swart.runwith.domain.running_shoes.mapper.RunningShoesDtoMapper;
import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        @Valid @RequestBody RunningShoesCreateControllerRequestDto controllerRequestDto
    ) {
        RunningShoesCreateServiceRequestDto serviceRequestDto =
            runningShoesDtoMapper.toRunningShoesCreateServiceRequestDto(controllerRequestDto);

        runningShoesService.create(
//            userDetails,
            serviceRequestDto
        );

        return ResponseEntity
            .status(CREATED)
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
            .status(OK)
            .body(serviceResponseDtoList);
    }

    /**
     * 러닝화 정보 단건 조회
     *
     * @param shoesId
     * @return
     */
    @GetMapping("/{shoes_id}")
    public ResponseEntity<RunningShoesReadServiceResponseDto> read(
//        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(name = "shoes_id") Long shoesId
    ) {
        RunningShoesReadServiceResponseDto serviceResponseDto =
            runningShoesService.read(
//            userDetails,
                shoesId
            );

        return ResponseEntity
            .status(OK)
            .body(serviceResponseDto);
    }

    /**
     * 러닝화 정보 수정
     *
     * @param shoesId
     * @param controllerRequestDto
     * @return
     */
    @PutMapping("/{shoes_id}")
    public ResponseEntity<Void> update(
//        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(name = "shoes_id") Long shoesId,
        @NotNull @RequestBody RunningShoesUpdateControllerRequestDto controllerRequestDto
    ) {
        RunningShoesUpdateServiceRequestDto serviceRequestDto =
            runningShoesDtoMapper.toRunningShoesUpdateServiceRequestDto(controllerRequestDto);

        runningShoesService.update(
//            userDetails,
            shoesId,
            serviceRequestDto
        );

        return ResponseEntity
            .status(OK)
            .build();
    }

    @DeleteMapping("/{shoes_id}")
    public ResponseEntity<Void> delete(
//        @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(name = "shoes_id") Long shoesId
    ) {
        runningShoesService.delete(
//            userDetails,
            shoesId
        );

        return ResponseEntity
            .status(OK)
            .build();
    }
}
