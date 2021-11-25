package com.revature.p1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p1")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!\n";
    }
}
