package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.ProductType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductTypeRepository extends CrudRepository<ProductType, String> {
    Optional<ProductType> findByNameAndSubType(String name, String subType);
}
