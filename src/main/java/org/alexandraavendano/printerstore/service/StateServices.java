package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.State;
import org.alexandraavendano.printerstore.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServices {
    private final StateRepository stateRepository;

    @Autowired
    public StateServices( StateRepository stateRepository){
        this.stateRepository = stateRepository;
    }

    public Iterable<State> getAll() {
        return stateRepository.findAll();
    }
}
