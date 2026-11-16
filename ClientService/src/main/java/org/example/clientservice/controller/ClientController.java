package org.example.clientservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.clientservice.entity.Client;
import org.example.clientservice.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientRepository.findById(id).orElse(null));
    }
}
