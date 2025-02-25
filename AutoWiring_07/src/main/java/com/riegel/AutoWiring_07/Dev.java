package com.riegel.AutoWiring_07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {
    
    @Autowired // this is called a field injection
    @Qualifier("desktop") // with small d for disambiguation
    private Computer computer;

    public void build(){

        computer.compile();
        
        System.out.println("I'm working on an awesome project!");
    }
}
