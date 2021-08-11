package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ClientNotFoundException;
import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.models.Role;
import com.practicespring.printerstore.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    private final ClientServices clientServices;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ClientController(ClientServices clientServices, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.clientServices = clientServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/users/login")
    Client getClient(@RequestBody Client client) {
        return clientServices.findBy(client.getEmail()).orElseThrow(() -> new ClientNotFoundException(client.getEmail()));
    }

    @PostMapping("/users/signin")
    Client createClient(@RequestBody Client newClient) {
        LOGGER.log(Level.FINE, "Saving a new client");
        Role role = new Role("client");
        newClient.setRole(role);
        newClient.setPassword(bCryptPasswordEncoder.encode(newClient.getPassword()));
        return clientServices.create(newClient);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        clientServices.delete(id);
    }
}