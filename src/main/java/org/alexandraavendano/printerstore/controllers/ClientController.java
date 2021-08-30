package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.exceptions.ClientNotFoundException;
import org.alexandraavendano.printerstore.models.Client;
import org.alexandraavendano.printerstore.service.ClientServicesI;
import org.alexandraavendano.printerstore.service.impl.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    private final ClientServicesI clientServices;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ClientController(ClientServices clientServices, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.clientServices = clientServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    Client createClient(@RequestBody Client newClient) {
        LOGGER.log(Level.FINE, "Saving a new client");
        newClient.setPassword(bCryptPasswordEncoder.encode(newClient.getPassword()));
        return clientServices.create(newClient);
    }

    @GetMapping( "/{id}")
    Client getClientByEmail(@PathVariable String id){
        return clientServices.findBy(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable String id) {
        clientServices.delete(id);
    }
}