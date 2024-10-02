package com.swart.runwith.domain.running_data.dto.controller;

import jakarta.validation.constraints.NotNull;

public record RunningDataCreateControllerRequestDto(
    @NotNull
    Long runningShoesId,
    @NotNull
    Integer distance,
    @NotNull
    Integer time,
    @NotNull
    Float averagePace,
    @NotNull
    String courseUrl
) {

}
