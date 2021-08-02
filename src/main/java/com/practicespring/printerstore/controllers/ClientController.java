package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Client;
import com.practicespring.printerstore.models.Role;
import com.practicespring.printerstore.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final ClientServices clientServices;

    @Autowired
    public ClientController(ClientServices clientServices){
        this.clientServices = clientServices;
    }

    @GetMapping("/users/{id}")
    Client getClient(@PathVariable String id) {
        return clientServices.findBy(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PostMapping("/users")
    Client createClient(@RequestBody Client newClient) {
        Role role = new Role("client");
        newClient.setRole(role);
        return clientServices.create(newClient);
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        clientServices.delete(id);
    }
}