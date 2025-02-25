package com.riegel.AutoWiring_07;

import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    public void compile(){
        System.out.println("Working on Desktop");
    }
}
