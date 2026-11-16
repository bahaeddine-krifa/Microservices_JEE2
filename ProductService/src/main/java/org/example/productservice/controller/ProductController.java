package org.example.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.productservice.entity.Product;
import org.example.productservice.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productRepository.findById(id).orElse(null));
    }

}
