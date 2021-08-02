package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, String> {

}
