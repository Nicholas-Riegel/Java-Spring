package com.riegel.demo_01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// this will output in browser at 8080
@RestController
public class Hello {

    @GetMapping("/")
    public String greet(){
        return "Hello world";
    }
}
