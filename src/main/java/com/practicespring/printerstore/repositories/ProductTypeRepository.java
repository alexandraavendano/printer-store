package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductTypeRepository extends CrudRepository<ProductType, String> {
    Optional<ProductType> findByNameAndAndSubType(String name, String subType);
}
