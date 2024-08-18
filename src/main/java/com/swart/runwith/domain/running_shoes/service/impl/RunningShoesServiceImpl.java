package com.swart.runwith.domain.running_shoes.service.impl;

import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesUpdateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.response.RunningShoesReadServiceResponseDto;
import com.swart.runwith.domain.running_shoes.entity.RunningShoes;
import com.swart.runwith.domain.running_shoes.exception.RunningShoesErrorCode;
import com.swart.runwith.domain.running_shoes.exception.RunningShoesException;
import com.swart.runwith.domain.running_shoes.mapper.RunningShoesEntityMapper;
import com.swart.runwith.domain.running_shoes.repository.RunningShoesRepository;
import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
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
public class RunningShoesServiceImpl implements RunningShoesService {

    // repository
    private final RunningShoesRepository runningShoesRepository;
    private final AuthRepository authRepository;

    // mapper
    private final RunningShoesEntityMapper runningShoesEntityMapper;

    // token 작성 전 test 용 user info 및 auth 반환 method
    private UserInfo testUserInfo() {
        return authRepository.findById(1L)
            .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND_AUTH)).getUserInfo();
    }

    @Override
    @Transactional
    public void create(
//        final UserDetails userDetails,
        final RunningShoesCreateServiceRequestDto serviceRequestDto
    ) {
        UserInfo userInfo = testUserInfo();

        RunningShoes runningShoes = runningShoesEntityMapper.toRunningShoes(
            serviceRequestDto,
            userInfo
        );

        runningShoesRepository.save(runningShoes);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RunningShoesReadServiceResponseDto> readAll(
//        UserDetails userDetails
    ) {
        UserInfo userInfo = testUserInfo();

        return runningShoesRepository
            .findByUserInfo(userInfo)
            .stream()
            .map(runningShoesEntityMapper::toRunningShoesReadServiceResponseDto)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RunningShoesReadServiceResponseDto read(
//        final UserDetails userDetails,
        final Long shoesId
    ) {
        UserInfo userInfo = testUserInfo();
        RunningShoes runningShoes = getRunningShoesById(shoesId);

        validateRunningShoesAccessAuthority(userInfo, runningShoes);

        return runningShoesEntityMapper.toRunningShoesReadServiceResponseDto(runningShoes);
    }


    @Override
    @Transactional
    public void update(
//        final UserDetails userDetails,
        final Long shoesId,
        final RunningShoesUpdateServiceRequestDto serviceRequestDto) {
        UserInfo userInfo = testUserInfo();
        RunningShoes runningShoes = getRunningShoesById(shoesId);

        validateRunningShoesAccessAuthority(userInfo, runningShoes);

        runningShoes.update(serviceRequestDto);
    }

    @Override
    @Transactional
    public void delete(
//        final UserDetails userDetails,
        final Long shoesId
    ) {
        UserInfo userInfo = testUserInfo();
        RunningShoes runningShoes = getRunningShoesById(shoesId);

        validateRunningShoesAccessAuthority(userInfo, runningShoes);

        runningShoesRepository.delete(runningShoes);
    }

    private RunningShoes getRunningShoesById(final Long shoesId) {
        return runningShoesRepository.findById(shoesId)
            .orElseThrow(
                () -> new RunningShoesException(RunningShoesErrorCode.NOT_FOUND_RUNNING_SHOES)
            );
    }

    private void validateRunningShoesAccessAuthority(
        final UserInfo userInfo,
        final RunningShoes runningShoes
    ) {
        if (!userInfo.equals(runningShoes.getUserInfo())) {
            throw new RunningShoesException(RunningShoesErrorCode.FORBIDDEN_RUNNING_SHOES);
        }
    }
}
