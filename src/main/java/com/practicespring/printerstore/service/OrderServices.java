package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Order;
import com.practicespring.printerstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServices {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServices(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> findBy(Long id) {
        return orderRepository.findById(id);
    }

    public Iterable<Order> findBy(String email) {
        return orderRepository.findByClient_Email(email);
    }
}