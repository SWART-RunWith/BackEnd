package com.swart.runwith.domain.running_shoes.service;

import com.swart.runwith.domain.running_shoes.dto.service.request.RunningShoesCreateServiceRequestDto;
import com.swart.runwith.domain.running_shoes.dto.service.response.RunningShoesReadServiceResponseDto;
import java.util.List;

public interface RunningShoesService {

    void create(
//        UserDetails userDetails,
        RunningShoesCreateServiceRequestDto serviceRequestDto
    );

    List<RunningShoesReadServiceResponseDto> readAll(
//        UserDetails userDetails,
    );
}
