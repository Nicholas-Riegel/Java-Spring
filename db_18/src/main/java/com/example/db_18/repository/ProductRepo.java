package com.example.db_18.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.db_18.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {} 
// need to specify the entity class and the type of the primary key in the <> brackets