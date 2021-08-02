package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String> {
    Client findByEmail(String email);
}
