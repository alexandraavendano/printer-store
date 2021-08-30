package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, String> {
    Optional<Client> findByEmail(String email);
}
