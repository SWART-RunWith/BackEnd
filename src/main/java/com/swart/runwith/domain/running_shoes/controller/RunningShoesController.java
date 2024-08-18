package com.swart.runwith.domain.running_shoes.controller;

import com.swart.runwith.domain.running_shoes.service.RunningShoesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoes")
@RequiredArgsConstructor
public class RunningShoesController {

    // service
    private final RunningShoesService runningShoesService;

}
