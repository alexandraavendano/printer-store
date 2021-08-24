package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Payment;
import com.practicespring.printerstore.service.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users/payments")
@CrossOrigin(origins = "http://localhost:3000")
class PaymentController {

    static final Logger LOGGER = Logger.getLogger(PaymentController.class.getName());

    private final PaymentServices paymentServices;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PaymentController(PaymentServices paymentServices, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.paymentServices = paymentServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("")
    Payment createPayment(@RequestBody Payment newPayment) {
        LOGGER.log(Level.FINE, "Saving a new credit card");
        newPayment.setCvv(bCryptPasswordEncoder.encode(newPayment.getCvv()));
        return paymentServices.create(newPayment);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping( "/{id}")
    Iterable<Payment> getPaymentByUserId(@PathVariable String id){
        return paymentServices.findBy(id);
    }

    @DeleteMapping("/{id}")
    void deletePayment(@PathVariable String id) {
        paymentServices.delete(id);
    }
}
