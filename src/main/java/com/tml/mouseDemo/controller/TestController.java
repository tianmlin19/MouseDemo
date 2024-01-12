package com.tml.mouseDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/common")
    public String commonHandler() {
        return "common handler";
    }

    /*@GetMapping("/mono")
    public Mono<String> monoHandler() {
        return "common handler";
    }*/
}
