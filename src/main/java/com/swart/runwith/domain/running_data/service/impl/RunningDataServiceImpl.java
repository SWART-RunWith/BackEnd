package com.swart.runwith.domain.running_data.service.impl;

import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.response.RunningDataReadServiceResponseDto;
import com.swart.runwith.domain.running_data.service.RunningDataService;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RunningDataServiceImpl implements RunningDataService {
    
    @Override
    public void create(final RunningDataCreateServiceRequestDto serviceRequestDto) {
    
    }
    
    @Override
    public List<RunningDataReadServiceResponseDto> readAll(final UserDetails userDetails) {
        return null;
    }
    
    @Override
    public RunningDataReadServiceResponseDto read(final Long runningDataId) {
        return null;
    }
    
    @Override
    public void update(
        final Long runningDataId,
        final RunningDataUpdateServiceRequestDto serviceRequestDto
    ) {
    
    }
    
    @Override
    public void delete(final Long runningDataId) {
    
    }
}
