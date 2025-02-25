package com.riegel.DependencyInjection_06;

import org.springframework.stereotype.Component;

@Component
public class Dev {
    
    public void build(){
        System.out.println("I'm working on an awesome project!");
    }
}
