package com.example.garden_integrated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.garden_integrated.model.Product;
import com.example.garden_integrated.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            // Update fields
            product.setName(updatedProduct.getName());
            product.setImage_link(updatedProduct.getImage_link());
            product.setRating(updatedProduct.getRating());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            // Save and return updated product
            return productRepository.save(product);
        }
        return null; // Product not found
    }

    public Product updateProductByName(String name, Product updatedProduct) {
        Product product = productRepository.findByName(name).orElse(null);
        if (product != null) {
            // Update fields
            product.setName(updatedProduct.getName());
            product.setImage_link(updatedProduct.getImage_link());
            product.setRating(updatedProduct.getRating());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            // Save and return updated product
            return productRepository.save(product);
        }
        return null; // Product not found
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteProductByName(String name) {
        productRepository.deleteByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
