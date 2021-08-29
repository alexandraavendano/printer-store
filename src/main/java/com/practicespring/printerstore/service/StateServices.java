package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.State;
import com.practicespring.printerstore.repositories.StateRepository;
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
