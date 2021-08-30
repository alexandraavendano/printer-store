package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.models.State;
import org.alexandraavendano.printerstore.service.impl.StateServices;
import org.alexandraavendano.printerstore.service.StateServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateServicesI stateServices;

    @Autowired
    public StateController(StateServices stateServices){
        this.stateServices = stateServices;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
    @GetMapping( "")
    Iterable<State> getStates(){
        return stateServices.getAll();
    }
}