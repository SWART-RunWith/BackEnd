package com.swart.runwith.domain.course_post.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.swart.runwith.domain.course_post.dto.controller.CoursePostCreateControllerRequestDto;
import com.swart.runwith.domain.course_post.dto.service.CoursePostCreateServiceRequestDto;
import com.swart.runwith.domain.course_post.mapper.CoursePostDtoMapper;
import com.swart.runwith.domain.course_post.service.CoursePostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<?> createCoursePost(
//        Auth userDetails,
        @Valid @RequestBody CoursePostCreateControllerRequestDto controllerRequestDto
    ) {
        CoursePostCreateServiceRequestDto serviceRequestDto =
            coursePostDtoMapper.toCoursePostCreateServiceRequestDto(controllerRequestDto);

        coursePostService.createCoursePost(
//            userDetails,
            serviceRequestDto
        );

        return ResponseEntity
            .status(CREATED)
            .build();
    }
}
