package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServices {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServices(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public void delete(String email) {
        clientRepository.deleteById(email);
    }

    public Optional<Client> findBy(String email) {
        return clientRepository.findById(email);
    }
}