package org.example.clientservice;

import org.example.clientservice.entity.Client;
import org.example.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            Client client1 = Client.builder().name("Bahaeddine Krifa").build();
            Client client2 = Client.builder().name("Yassine saidi").build();
            Client client3 = Client.builder().name("ahmed rouatbi").build();

            clientRepository.saveAll(List.of(client1, client2, client3));
        };
    }
}
