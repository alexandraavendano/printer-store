package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.State;
import org.alexandraavendano.printerstore.repositories.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateServicesTest {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    StateServices stateService;

    @Test
    public void createAndFind(){
        State expectedState = new State();
        expectedState.setName("Print Order");
        stateRepository.save(expectedState);

        Iterable<State> actualState = stateService.getAll();

        assertEquals(expectedState, actualState.iterator().next());
    }
}
