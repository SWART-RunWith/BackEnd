package com.swart.runwith.domain.running_shoes.service;

import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;

public interface RunningShoesService {

    void create(
//        UserDetails userDetails,
        RunningShoesCreateServiceRequestDto serviceRequestDto
    );
}
