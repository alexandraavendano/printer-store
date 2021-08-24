package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, String> {
    Iterable<Payment> findByClient_Email(String email);
}