package com.logisticsapi.services;

import com.logisticsapi.exceptions.EmailException;
import com.logisticsapi.model.Client;
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
                    throw new EmailException(
                        "Client with email " + client.getEmail() + " already exists"
                    );
                }
            });
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
