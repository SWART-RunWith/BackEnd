package com.swart.runwith.domain.running_data.controller;

import com.swart.runwith.domain.running_data.dto.controller.RunningDataCreateControllerRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.mapper.RunningDataDtoMapper;
import com.swart.runwith.domain.running_data.service.RunningDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.HttpStatus.CREATED;

// json을 body로 쓸 거면 RestController 사용 추천
@Controller
@RequiredArgsConstructor
public class RunningDataController {
    
    private final RunningDataService runningDataService;
    
    private final RunningDataDtoMapper runningDataDtoMapper;
    
    @PostMapping
    public ResponseEntity<Void> create(
        @Valid @RequestBody RunningDataCreateControllerRequestDto controllerRequestDto
    ) {
        RunningDataCreateServiceRequestDto serviceRequestDto = runningDataDtoMapper.toRunningDataCreateServiceRequestDto(
            controllerRequestDto);
        
        runningDataService.create(
            serviceRequestDto
        );
        
        return ResponseEntity
            .status(CREATED)
            .build();
    }
}
