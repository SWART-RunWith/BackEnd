package com.swart.runwith.domain.running_data.dto.service.request;

public record RunningDataUpdateServiceRequestDto(
    Long runningShoesId,
    Integer distance,
    Integer time,
    Float averagePace,
    String courseUrl
) {

}
