package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Payment;
import org.alexandraavendano.printerstore.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices implements PaymentServicesI {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServices(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void delete(String email) {
        paymentRepository.deleteById(email);
    }

    public Iterable<Payment> findBy(String email) {
        return paymentRepository.findByClient_Email(email);
    }
}