package com.riegel.AutoWiring_07;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // this is like a default for disambiguation
public class Laptop implements Computer{

    public void compile(){
        System.out.println("Working with laptop.");
    }
}
