package com.swart.runwith.domain.running_shoes.service.impl;

import com.swart.runwith.domain.running_shoes.mapper.RunningShoesEntityMapper;
import com.swart.runwith.domain.running_shoes.repository.RunningShoesRepository;
import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunningShoesServiceImpl implements RunningShoesService {

    // repository
    private final RunningShoesRepository runningShoesRepository;

    // mapper
    private final RunningShoesEntityMapper runningShoesEntityMapper;
}
