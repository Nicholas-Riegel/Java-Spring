package com.example.db_18.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to generate getters, setters, equals, hashcode, and toString
@AllArgsConstructor // Lombok annotation to generate a constructor with all arguments
@NoArgsConstructor // Lombok annotation to generate a constructor with no arguments
@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private double price;
}
