package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Client;
import org.alexandraavendano.printerstore.models.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServicesTest {

    @Autowired
    private ClientServices clientServices;

    @Test
    public void createEmployeeAndFindByEmailTest() {

        Client expectedClient = new Client();
        expectedClient.setEmail("client@test.com");
        expectedClient.setFirstName("clientName");
        expectedClient.setLastName("clientLastName");
        expectedClient.setRole(new Role("ROLE_CLIENT"));
        clientServices.create(expectedClient);
        Client actualClient = clientServices.findBy("client@test.com").get();

        assertEquals(actualClient.getEmail(), expectedClient.getEmail());
        assertEquals(actualClient.getPassword(), expectedClient.getPassword());
        assertEquals(actualClient.getRole().getName(), expectedClient.getRole().getName());
        assertEquals(actualClient.getFirstName(), expectedClient.getFirstName());
        assertEquals(actualClient.getLastName(), expectedClient.getLastName());
    }
}
