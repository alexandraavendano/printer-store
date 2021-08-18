package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.CustomizableProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomizableProductRepository extends CrudRepository<CustomizableProduct, Integer> {
    List<CustomizableProduct> getCustomizableProductByType_Name(String productType);
}