package com.example.backend25.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend25.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // JPQL Query
    @Query("SELECT p from Product p WHERE" 
        +" LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))"
        +" OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))" 
        +" OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%'))"
        +" OR LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProducts(String keyword);
}
