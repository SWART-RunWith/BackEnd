package com.swart.runwith.domain.running_data.dto.controller;

public record RunningDataUpdateControllerRequestDto(
    Long runningShoesId,
    Integer distance,
    Integer time,
    String averagePace,
    String courseUrl
) {

}
