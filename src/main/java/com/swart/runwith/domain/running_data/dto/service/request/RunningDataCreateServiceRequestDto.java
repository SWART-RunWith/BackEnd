package com.swart.runwith.domain.running_data.dto.service.request;

public record RunningDataCreateServiceRequestDto(
    Long runningShoesId,
    Integer distance,
    Integer time,
    Float averagePace,
    String courseUrl
) {

}
