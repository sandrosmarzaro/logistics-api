package com.logisticsapi.services;

import com.logisticsapi.exceptions.DomainException;
import com.logisticsapi.models.Client;
import com.logisticsapi.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Client create(Client client) {
        clientRepository.findByEmail(client.getEmail())
            .ifPresent(existingClient -> {
                if (!existingClient.equals(client)) {
                    throw new DomainException(
                        "Client with email " + client.getEmail() + " already exists"
                    );
                }
            });
        return clientRepository.save(client);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
            .orElseThrow(() -> new DomainException("Client not found"));
    }

    @Transactional
    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
