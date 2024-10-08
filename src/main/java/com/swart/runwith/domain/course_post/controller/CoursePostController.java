package com.swart.runwith.domain.course_post.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.swart.runwith.domain.course_post.dto.controller.CoursePostCreateControllerRequestDto;
import com.swart.runwith.domain.course_post.dto.controller.CoursePostUpdateControllerRequestDto;
import com.swart.runwith.domain.course_post.dto.service.request.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.request.CoursePostUpdateServiceRequestDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostPreviewServiceResponseDto;
import com.swart.runwith.domain.course_post.dto.service.response.CoursePostReadServiceResponseDto;
import com.swart.runwith.domain.course_post.mapper.CoursePostDtoMapper;
import com.swart.runwith.domain.course_post.service.CoursePostService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursePostController {

    // service
    private final CoursePostService coursePostService;

    // mapper
    private final CoursePostDtoMapper coursePostDtoMapper;

    @PostMapping("")
    public ResponseEntity<Void> create(
//        Auth userDetails,
        @Valid @RequestBody CoursePostCreateControllerRequestDto controllerRequestDto
    ) {
        CoursePostCreateServiceRequestDto serviceRequestDto =
            coursePostDtoMapper.toCoursePostCreateServiceRequestDto(controllerRequestDto);

        coursePostService.create(
//            userDetails,
            serviceRequestDto
        );

        return ResponseEntity
            .status(CREATED)
            .build();
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<CoursePostReadServiceResponseDto> read(
        @PathVariable(name = "course_id") Long courseId
    ) {
        return ResponseEntity
            .status(OK)
            .body(coursePostService.read(courseId));
    }

    @GetMapping("")
    public ResponseEntity<List<CoursePostReadServiceResponseDto>> readAll() {
        return ResponseEntity
            .status(OK)
            .body(coursePostService.readAll());
    }

    @GetMapping("/mine")
    public ResponseEntity<List<CoursePostReadServiceResponseDto>> readMine(
//        Auth userDetails
    ) {
        return ResponseEntity
            .status(OK)
            .body(coursePostService.readMine(
//                userDetails
            ));
    }

    @GetMapping("/search")
    public ResponseEntity<List<CoursePostPreviewServiceResponseDto>> searchByTitle(
        @RequestParam(name = "title") String title
    ) {
        return ResponseEntity.ok(coursePostService.searchByTitle(title));
    }

    @PutMapping("/{course_id}")
    public ResponseEntity<Void> update(
        @PathVariable(name = "course_id") Long courseId,
        @Valid @RequestBody CoursePostUpdateControllerRequestDto controllerRequestDto
    ) {
        CoursePostUpdateServiceRequestDto serviceRequestDto =
            coursePostDtoMapper.toCoursePostUpdateServiceRequestDto(controllerRequestDto);

        coursePostService.update(
            courseId,
            serviceRequestDto
        );

        return ResponseEntity
            .status(OK)
            .build();
    }

    @DeleteMapping("/{course_id}")
    public ResponseEntity<Void> delete(
        @PathVariable(name = "course_id") Long courseId
    ) {
        coursePostService.delete(courseId);

        return ResponseEntity
            .status(OK)
            .build();
    }
}
