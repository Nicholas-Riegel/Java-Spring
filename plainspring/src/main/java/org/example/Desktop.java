package org.example;

public class Desktop implements Computer {

    public Desktop(){
        System.out.println("From Desktop class constructor.");
    }

    public void compile(){
        System.out.println("Compiling from Desktop class.");
    }
}
