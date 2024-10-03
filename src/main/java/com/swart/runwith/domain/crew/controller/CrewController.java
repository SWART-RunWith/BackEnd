package com.swart.runwith.domain.crew.controller;

import com.swart.runwith.domain.crew.response.CrewRankReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewReadServiceResponseDto;
import com.swart.runwith.domain.crew.response.CrewUserReadServiceResponseDto;
import com.swart.runwith.domain.crew.service.CrewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crews")
@RequiredArgsConstructor
public class CrewController {

    private final CrewService crewService;

    @GetMapping("/my")
    public ResponseEntity<List<CrewUserReadServiceResponseDto>> getMyCrew() {
        return ResponseEntity.ok(crewService.getMyCrew());
    }

    @GetMapping("/{crewId}")
    public ResponseEntity<CrewReadServiceResponseDto> getCrewInfo(
        @PathVariable(name = "crewId") Long crewId
    ) {
        return ResponseEntity.ok(crewService.getCrewInfo(crewId));
    }

    @GetMapping("/{crewId}/rank")
    public ResponseEntity<List<CrewRankReadServiceResponseDto>> getRank(
        @PathVariable(name = "crewId") Long crewId
    ) {
        return ResponseEntity.ok(crewService.getRank(crewId));
    }
}
