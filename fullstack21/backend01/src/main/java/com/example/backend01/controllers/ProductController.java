package com.example.backend01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend01.models.Product;
import com.example.backend01.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;
    
    // GET ALL
    // @GetMapping("/products")
    // public List<Product> getProducts() {
    //     return productService.getProducts();
    // }

    // GET ALL
    // in order to return status code 200 OK, we need to return ResponseEntity
    @GetMapping("/products") 
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    // POST ONE
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);        
    }

    // GET ONE
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {

        Product product = productService.getProductById(id);

        if (product == null) 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // UPDATE ONE
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    // DELETE ONE
    @DeleteMapping("/products/{id}")
    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

}
