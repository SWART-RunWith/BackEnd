package com.swart.runwith.domain.running_data.dto.service.response;

public record RunningDataReadServiceResponseDto(
    Long id,
    Long runningShoesId,
    Integer distance,
    Integer time,
    Float averagePace,
    String courseUrl
) {

}
