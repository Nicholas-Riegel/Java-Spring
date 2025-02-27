package com.example.backend25.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend25.models.Product;
import com.example.backend25.services.ProductService;

import java.io.IOException;
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
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(
        @PathVariable int id, 
        @RequestPart Product product, 
        @RequestPart MultipartFile imageFile) throws IOException {
        
        try {
            productService.updateProduct(id, product, imageFile);
            return new ResponseEntity<>("Product updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // DELETE ONE
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        
        Product product = productService.getProductById(id);
        
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        
        } else {
            
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        }
    }

    // SEARCH
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        System.out.println("Searching with keyword: " + keyword);
        List<Product> products = productService.searchProducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
