package org.alexandraavendano.printerstore.service.impl;

import com.google.common.collect.ImmutableList;
import org.alexandraavendano.printerstore.models.*;
import org.alexandraavendano.printerstore.repositories.StateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServicesTest {

    @Autowired
    OrderServices orderServices;

    @Autowired
    private ClientServices clientServices;

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

        Client client = new Client();
        client.setEmail("client1@test.com");
        client.setFirstName("clientName");
        client.setLastName("clientLastName");
        client.setRole(new Role("ROLE_CLIENT"));
        Client expectedClient = clientServices.create(client);

        Item item = new Item();
        item.setId(1L);
        item.setQuantity(1);
        item.setPrice(3.0);
        item.setDesignNotes("Great Idea for Design");
        item.setState(expectedState);
        Item expectedItem = itemServices.save(item);

        Order order = new Order();
        order.setId(1);
        order.setTotalPrice(25);
        order.setState(expectedState);
        order.setClient(expectedClient);
        order.setItems(Arrays.asList(expectedItem));
        Order expectedOrder = orderServices.create(order);

        List<Order> actualOrder = ImmutableList.copyOf(orderServices.findBy(expectedClient.getEmail()));
        assertEquals(expectedOrder, actualOrder.get(0));
    }
}
