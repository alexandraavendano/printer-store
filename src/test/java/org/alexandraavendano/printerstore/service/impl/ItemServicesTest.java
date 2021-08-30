package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Item;
import org.alexandraavendano.printerstore.models.State;
import org.alexandraavendano.printerstore.repositories.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServicesTest {

    @Autowired
    ItemServices itemServices;

    @Autowired
    StateRepository stateRepository;

    @Test
    @Transactional
    public void createAndFind(){
        State state = new State();
        state.setName("Designed");
        State expectedState = stateRepository.save(state);

        Item item = new Item();
        item.setId(1L);
        item.setQuantity(1);
        item.setPrice(3.0);
        item.setDesignNotes("Great Idea for Design");
        item.setState(expectedState);
        Item expectedItem = itemServices.save(item);

        Item actualItem = itemServices.getById(1L).get();
        assertEquals(expectedItem, actualItem);
    }
}
