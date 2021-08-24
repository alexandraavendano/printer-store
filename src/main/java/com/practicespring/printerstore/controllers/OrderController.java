package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Order;
import com.practicespring.printerstore.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    private final OrderServices orderServices;

    @Autowired
    public OrderController(OrderServices orderServices){
        this.orderServices = orderServices;
    }

    @PostMapping("")
    Order createOrder(@RequestBody Order order) {
        LOGGER.log(Level.FINE, "Saving a order");
        return orderServices.create(order);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping( "/{email}")
    Iterable<Order> getOrderByUserId(@PathVariable String email){
        return orderServices.findBy(email);
    }

    @DeleteMapping("/{id}")
    void deletePayment(@PathVariable Long id) {
        orderServices.delete(id);
    }
}
