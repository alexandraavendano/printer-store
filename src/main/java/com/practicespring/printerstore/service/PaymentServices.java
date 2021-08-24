package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Payment;
import com.practicespring.printerstore.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

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