package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByClient_EmailOrderByDateDesc(String email);
}