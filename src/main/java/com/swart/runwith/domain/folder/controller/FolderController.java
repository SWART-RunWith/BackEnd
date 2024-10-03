package com.swart.runwith.domain.folder.controller;

import com.swart.runwith.domain.folder.dto.service.response.FolderReadServiceResponseDto;
import com.swart.runwith.domain.folder.service.FolderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/folders")
@RequiredArgsConstructor
public class FolderController {

    private final FolderService folderService;

    @GetMapping("")
    public ResponseEntity<List<FolderReadServiceResponseDto>> getAll() {
        return ResponseEntity
            .ok(folderService.getAll());
    }
}
