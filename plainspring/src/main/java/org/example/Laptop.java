package org.example;

public class Laptop implements Computer{

    public Laptop(){
        System.out.println("From Laptop class constructor.");
    }

    public void compile(){
        System.out.println("Compiling from Laptop class.");
    }
}
