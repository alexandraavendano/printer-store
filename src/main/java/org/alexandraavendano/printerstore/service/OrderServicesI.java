package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Order;

public interface OrderServicesI {
    Order create(Order order);

    Iterable<Order> findBy(String email);

    Iterable<Order> findAll();

    void delete(Long id);
}
