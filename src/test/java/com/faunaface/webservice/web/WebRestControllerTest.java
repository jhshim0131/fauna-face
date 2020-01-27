package com.faunaface.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestControllerTest {

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}