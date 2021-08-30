package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Client;
import org.alexandraavendano.printerstore.models.Payment;
import org.alexandraavendano.printerstore.models.Role;
import org.alexandraavendano.printerstore.repositories.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServicesTest {

    @Autowired
    PaymentServices paymentServices;

    @Autowired
    private ClientServices clientServices;

    @Test
    @Transactional
    public void createAndFind(){
        Client client = new Client();
        client.setEmail("client5@test.com");
        client.setFirstName("clientName");
        client.setLastName("clientLastName");
        client.setRole(new Role("ROLE_CLIENT"));
        Client expectedClient = clientServices.create(client);

        Payment payment = new Payment();
        payment.setCvv("1234");
        payment.setCardHolderName("Holder name");
        payment.setCardNumber("1234123412341234");
        payment.setMonth(8);
        payment.setYear(2022);
        payment.setClient(expectedClient);
        Payment expectedPayment = paymentServices.create(payment);

        Iterable<Payment> payments = paymentServices.findBy(expectedClient.getEmail());
        assertEquals(expectedPayment, payments.iterator().next());
    }
}
