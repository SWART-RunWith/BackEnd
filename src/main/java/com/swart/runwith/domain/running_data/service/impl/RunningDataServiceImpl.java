package com.swart.runwith.domain.running_data.service.impl;

import com.swart.runwith.domain.running_data.dto.service.request.RunningDataCreateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.request.RunningDataUpdateServiceRequestDto;
import com.swart.runwith.domain.running_data.dto.service.response.RunningDataReadServiceResponseDto;
import com.swart.runwith.domain.running_data.entity.RunningData;
import com.swart.runwith.domain.running_data.exception.RunningDataErrorCode;
import com.swart.runwith.domain.running_data.exception.RunningDataException;
import com.swart.runwith.domain.running_data.mapper.RunningDataEntityMapper;
import com.swart.runwith.domain.running_data.repository.RunningDataRepository;
import com.swart.runwith.domain.running_data.service.RunningDataService;
import com.swart.runwith.domain.user.entity.UserInfo;
import com.swart.runwith.domain.user.exception.UserErrorCode;
import com.swart.runwith.domain.user.exception.UserException;
import com.swart.runwith.domain.user.repository.AuthRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RunningDataServiceImpl implements RunningDataService {
    
    private final RunningDataRepository runningDataRepository;
    private final AuthRepository authRepository;
    private final RunningDataEntityMapper runningDataEntityMapper;
    
    private UserInfo testUserInfo() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH)).getUserInfo();
    }
    
    @Override
    public void create(
        final RunningDataCreateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();
        
        RunningData runningData = runningDataEntityMapper.toRunningData(
            serviceRequestDto,
            userInfo
        );
        
        runningDataRepository.save(runningData);
    }
    
    @Override
    @Transactional
    public List<RunningDataReadServiceResponseDto> readAll(
//        final UserDetails userDetails
        ) {
        UserInfo userInfo = testUserInfo();
        
        return runningDataRepository
            .findByUserInfo(userInfo)
            .stream()
            .map(runningDataEntityMapper::toRunningDataReadServiceResponseDto)
            .toList();
    }
    
    @Override
    @Transactional
    public RunningDataReadServiceResponseDto read(
        final Long runningDataId
    ) {
        UserInfo userInfo = testUserInfo();
        RunningData runningData = getRunningDataById(runningDataId);
        
        return runningDataEntityMapper.toRunningDataReadServiceResponseDto(runningData);
    }
    
    @Override
    @Transactional
    public void update(
        final Long runningDataId,
        final RunningDataUpdateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();
        RunningData runningData = getRunningDataById(runningDataId);
        
        runningData.update(serviceRequestDto);
    }
    
    @Override
    @Transactional
    public void delete(
        final Long runningDataId
    ) {
        UserInfo userInfo = testUserInfo();
        RunningData runningData = getRunningDataById(runningDataId);
        
        runningDataRepository.delete(runningData);
    }
    
    private RunningData getRunningDataById(final Long runningDataId) {
        return runningDataRepository.findById(runningDataId)
            .orElseThrow(
                () -> new RunningDataException(RunningDataErrorCode.NOT_FOUND_RUNNING_DATA
            )
        );
    }
}
