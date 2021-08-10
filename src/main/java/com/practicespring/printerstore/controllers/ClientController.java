package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ClientNotFoundException;
import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.models.Role;
import com.practicespring.printerstore.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices){
        this.clientServices = clientServices;
    }

    @GetMapping("/users")
    Client getClient(@RequestParam String id) {
        return clientServices.findBy(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PostMapping("/users")
    Client createClient(@RequestBody Client newClient) {
        LOGGER.log(Level.INFO, "Saving a new client");
        Role role = new Role("client");
        newClient.setRole(role);
        return clientServices.create(newClient);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        clientServices.delete(id);
    }
}