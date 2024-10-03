package com.swart.runwith.domain.crew.service;

import com.swart.runwith.domain.crew.response.CrewRankReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewUserReadServiceResponseDto;
import java.util.List;

public interface CrewService {

    List<CrewUserReadServiceResponseDto> getMyCrew();

    CrewReadServiceResponseDto getCrewInfo(Long crewId);

    List<CrewRankReadServiceResponseDto> getRank(Long crewId);
}
