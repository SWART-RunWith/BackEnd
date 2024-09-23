package com.swart.runwith.domain.running_data.dto.controller;

public record RunningDataUpdateControllerRequestDto(
    Long runningShoesId,
    Integer distance,
    Integer time,
    Float averagePace,
    String courseUrl
) {

}
