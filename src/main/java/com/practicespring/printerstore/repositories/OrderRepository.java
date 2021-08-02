package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
