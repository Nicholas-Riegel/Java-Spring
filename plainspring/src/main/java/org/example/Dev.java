package org.example;

public class Dev {

    // private Laptop laptop;
    public Computer computer;
    // private int age;

    public Dev(){
        System.out.println("From Dev class constructor");
    }
    
    // public Dev(int age) {
    //     this.age = age;
    // }

    public void build(){
        System.out.println("I'm working on an awesome project!");
        computer.compile();
    }


    // public int getAge() {
    //     return age;
    // }


    // public void setAge(int age) {
    //     this.age = age;
    // }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    // public void setLaptop(Laptop laptop) {
    //     this.laptop = laptop;
    // }

    // public Laptop getLaptop() {
    //     return laptop;
    // }    
}
