package com.swart.runwith.domain.running_data.service;

import com.swart.runwith.domain.running_data.dto.service.response.RunningDataReadServiceResponseDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import org.springframework.boot.SpringApplication.Running;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RunningDataService {
    
    void create(
        RunningDataCreateServiceRequestDto serviceRequestDto
    );
    
    void createFolder(
        RunningDataCreateServiceRequestDto serviceRequestDto
    );
    
    List<RunningDataReadServiceResponseDto> readFolder(
//        Long runningDataFolderId
    );
    
    List<RunningDataReadServiceResponseDto> readAll(
//        UserDetails userDetails
    );
    
    RunningDataReadServiceResponseDto read(
        Long runningDataId
    );
    
    void update(
        Long runningDataId,
        RunningDataUpdateServiceRequestDto serviceRequestDto
    );
    
    void updateFolder(
        Long runningDataFolderId,
        RunningDataUpdateServiceRequestDto serviceRequestDto
    );
    
    void delete(
        Long runningDataId
    );
    
    void deleteFolder(
        Long runningDataFolderId
    );
}
