package com.swart.runwith.domain.running_data.controller;

import com.swart.runwith.domain.running_data.dto.controller.RunningDataCreateControllerRequestDto;
import com.swart.runwith.domain.running_data.dto.controller.RunningDataUpdateControllerRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.response.RunningDataReadServiceResponseDto;
import com.swart.runwith.domain.running_data.mapper.RunningDataDtoMapper;
import com.swart.runwith.domain.running_data.service.RunningDataService;
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
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
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
    
    @PostMapping
    public ResponseEntity<Void> createFolder(
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
    
    @GetMapping("")
    public ResponseEntity<List<RunningDataReadServiceResponseDto>> readAll(
    
    ) {
        List<RunningDataReadServiceResponseDto> serviceResponseDtoList =
            runningDataService.readAll(
            
            );
    
    return ResponseEntity
        .status(OK)
        .body(serviceResponseDtoList);
    }
    
    @GetMapping("/{folder_id}")
    public ResponseEntity<List<RunningDataReadServiceResponseDto>> readFolder(
    
    ) {
        List<RunningDataReadServiceResponseDto> serviceResponseDtoList =
            runningDataService.readFolder(
            
            );
        
        return ResponseEntity
            .status(OK)
            .body(serviceResponseDtoList);
    }
    
    @GetMapping("/{data_id}")
    public ResponseEntity<RunningDataReadServiceResponseDto> read(
        @PathVariable(name = "data_id") Long runsId
    ) {
        RunningDataReadServiceResponseDto serviceResponseDto = runningDataService.read(
            runsId
        );
        
        return ResponseEntity
            .status(OK)
            .body(serviceResponseDto);
    }
    
    @PutMapping("/{runs_id}")
    public ResponseEntity<Void> update(
        @PathVariable(name = "runs_id") Long runsId,
        @NotNull @RequestBody RunningDataUpdateControllerRequestDto controllerRequestDto
    ) {
        RunningDataUpdateServiceRequestDto serviceRequestDto =
            runningDataDtoMapper.toRunningDataUpdateServiceRequestDto(controllerRequestDto);
        
        runningDataService.update(
            runsId,
            serviceRequestDto
        );
        
        return ResponseEntity
            .status(OK)
            .build();
    }
    
    @DeleteMapping("/{runs_id}")
    public ResponseEntity<Void> delete(
        @PathVariable(name = "runs_id") Long runsId
    ) {
        runningDataService.delete(
            runsId
        );
        
        return ResponseEntity
            .status(OK)
            .build();
    }
}
