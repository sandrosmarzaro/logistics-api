package com.logisticsapi.controllers;

import com.logisticsapi.models.Client;
import com.logisticsapi.repositories.ClientRepository;
import com.logisticsapi.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientRepository clientRepository;
    private ClientService clientService;

    @GetMapping
    public List<Client> readClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> readClient(@PathVariable long id) {
        return clientRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@Valid @PathVariable long id, @RequestBody Client client) {
        return clientRepository.findById(id)
                .map(existingClient -> {
                    existingClient.setName(client.getName());
                    existingClient.setEmail(client.getEmail());
                    existingClient.setPhone(client.getPhone());
                    return ResponseEntity.ok(clientService.create(existingClient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id) {
        if(!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
