package com.kamilcieslik.spring_boot.learninginterceptorslogging.services.test.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TestController {
    @GetMapping(value = "/test")
    public String getUsersInfo() {
        return "Test";
    }
}
