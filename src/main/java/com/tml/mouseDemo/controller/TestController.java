package com.tml.mouseDemo.controller;

import com.tml.mouseDemo.constants.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/common")
    public CommonResponse<String> commonHandler() {
        return CommonResponse.success("common handler");
    }

}
