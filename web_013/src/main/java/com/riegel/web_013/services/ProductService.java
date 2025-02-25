package com.riegel.web_013.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.riegel.web_013.models.Product;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
        new Product(1, "Product 1", 100.0),
        new Product(2, "Product 2", 200.0),
        new Product(3, "Product 3", 300.0)
    ));

    public List<Product> getProductsFromDB() {
        return products;
    }

    public Product getProductById(int prodId) {
        return products
            .stream()
            .filter(p -> p.getId() == prodId)
            .findFirst()
            .orElse(new Product(0, "No product", 0));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                return;
            }
        }
    }

    public void deleteProductById(int prodId) {
        products.removeIf(p -> p.getId() == prodId);
    }
}
