package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
