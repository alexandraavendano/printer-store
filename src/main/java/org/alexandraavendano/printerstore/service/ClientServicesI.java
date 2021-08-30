package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Client;

import java.util.Optional;

public interface ClientServicesI {

    Client create(Client client);

    Optional<Client> findBy(String email);

    void delete(String email);
}