package com.riegel.web_013.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/")
    public String greet() {
        return "Hello web!";
    }
    
    @GetMapping("/about")
    public String about() {
        return "About us!";
    }
    
}
