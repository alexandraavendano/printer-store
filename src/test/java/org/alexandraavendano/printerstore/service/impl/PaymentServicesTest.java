package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.repositories.PaymentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServicesTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    void createAndFind(){

    }
}
