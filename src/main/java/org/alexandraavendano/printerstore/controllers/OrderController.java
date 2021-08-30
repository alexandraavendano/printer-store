package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.models.Order;
import org.alexandraavendano.printerstore.service.impl.OrderServices;
import org.alexandraavendano.printerstore.service.OrderServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());

    private final OrderServicesI orderServices;

    @Autowired
    public OrderController(OrderServices orderServices){
        this.orderServices = orderServices;
    }

    @PostMapping("/users/orders")
    Order createOrder(@RequestBody Order order) {
        LOGGER.log(Level.FINE, "Saving a order");
        return orderServices.create(order);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping( "/users/orders/{email}")
    Iterable<Order> getOrderByUserId(@PathVariable String email){
        return orderServices.findBy(email);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_EMPLOYEE')")
    @GetMapping( "/orders")
    Iterable<Order> getOrderByUserId(){
        return orderServices.findAll();
    }
}
