package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Payment;

public interface PaymentServicesI {

    Payment create(Payment payment);

    Iterable<Payment> findBy(String email);

    void delete(String email);
}