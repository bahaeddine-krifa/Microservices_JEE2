package org.example.productservice;

import org.example.productservice.entity.Product;
import org.example.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            Product product1 = Product.builder()
                    .name("Laptop Dell XPS 15")
                    .price(4500.0)
                    .build();

            Product product2 = Product.builder()
                    .name("Mechanical Keyboard")
                    .price(250.5)
                    .build();

            Product product3 = Product.builder()
                    .name("Wireless Mouse")
                    .price(85.0)
                    .build();

            productRepository.saveAll(List.of(product1, product2, product3));
        };
    }
}
