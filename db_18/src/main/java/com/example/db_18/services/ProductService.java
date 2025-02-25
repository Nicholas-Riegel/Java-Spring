package com.example.db_18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.db_18.models.Product;
import com.example.db_18.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;
    
    public List<Product> getProductsFromDB() {
        return productRepo.findAll();
    }

    public Product getProductById(int prodId) {
        return productRepo.findById(prodId).orElse(null);
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void updateProduct(Product product) {
        productRepo.save(product); // save() can be used to add a new product or update an existing product
    }

    public void deleteProductById(int prodId) {
        productRepo.deleteById(prodId);
    }
}
