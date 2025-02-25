package com.example.backend25.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend25.models.Product;
import com.example.backend25.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<?> addProduct(
        @RequestPart Product product, 
        @RequestPart MultipartFile imageFile) throws Throwable {
        
        try {
        
            Product responseProduct = productService.addProduct(product, imageFile);
        
            return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
        
        } catch (Exception e) {
        
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET IMAGE
    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {

        Product product = productService.getProductById(id);
        byte[] imageData = product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageData);
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
