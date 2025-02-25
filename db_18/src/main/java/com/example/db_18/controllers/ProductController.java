package com.example.db_18.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.db_18.models.Product;
import com.example.db_18.services.ProductService;

@RestController
public class ProductController {

    @Autowired // to let Spring inject the ProductService object
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProductsFromDB();
    }
    
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return productService.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }
    
    @DeleteMapping("/products/{prodId}")
    public void deleteProductById(@PathVariable int prodId) {
        productService.deleteProductById(prodId);
    }
}