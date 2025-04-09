package com.apps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String welcome() {
        System.out.println("hello world...simple message.");
        System.out.println("updated message.");
        return "welcome";
    }

}
