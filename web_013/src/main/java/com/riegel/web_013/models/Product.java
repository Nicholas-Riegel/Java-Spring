package com.riegel.web_013.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Lombok annotation to generate getters, setters, equals, hashcode, and toString
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
public class Product {

    private int id;
    private String name;
    private double price;
}
