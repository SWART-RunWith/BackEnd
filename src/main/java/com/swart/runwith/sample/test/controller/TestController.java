package com.swart.runwith.sample.test.controller;

import com.swart.runwith.sample.test.dto.controller.TestCreateControllerRequestDto;
import com.swart.runwith.sample.test.dto.controller.TestUpdateControllerRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestCreateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.request.TestUpdateServiceRequestDto;
import com.swart.runwith.sample.test.dto.service.response.TestReadServiceResponseDto;
import com.swart.runwith.sample.test.mapper.TestDtoMapper;
import com.swart.runwith.sample.test.service.TestService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {

    // service
    private final TestService testService;

    // mapper
    private final TestDtoMapper testDtoMapper;

    @PostMapping("")
    public ResponseEntity<?> create(
        @Valid @RequestBody TestCreateControllerRequestDto controllerRequestDto
    ) {
        TestCreateServiceRequestDto serviceRequestDto =
            testDtoMapper.toTestCreateServiceRequestDto(controllerRequestDto);

        testService.create(serviceRequestDto);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
    }

    @GetMapping("/{test_id}")
    public ResponseEntity<TestReadServiceResponseDto> read(
        @PathVariable(name = "test_id") Long testId
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(testService.read(testId));
    }

    @GetMapping("")
    public ResponseEntity<List<TestReadServiceResponseDto>> readAll() {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(testService.readAll());
    }

    @PutMapping("/{test_id}")
    public ResponseEntity<?> update(
        @PathVariable(name = "test_id") Long testId,
        @NotNull @RequestBody TestUpdateControllerRequestDto controllerRequestDto
    ) {
        TestUpdateServiceRequestDto serviceRequestDto = testDtoMapper.toTestUpdateServiceRequestDto(
            controllerRequestDto);

        testService.update(testId, serviceRequestDto);

        return ResponseEntity
            .status(HttpStatus.OK)
            .build();

    }

    @DeleteMapping("/{test_id}")
    public ResponseEntity<?> delete(@PathVariable(name = "test_id") Long testId) {
        testService.delete(testId);

        return ResponseEntity
            .status(HttpStatus.OK)
            .build();
    }
}
