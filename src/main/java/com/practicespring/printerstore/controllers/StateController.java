package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.State;
import com.practicespring.printerstore.service.StateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/states")
public class StateController {

    private final StateServices stateServices;

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