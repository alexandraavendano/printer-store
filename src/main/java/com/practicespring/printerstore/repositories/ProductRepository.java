package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> getProductByType_Name(String productType);
}