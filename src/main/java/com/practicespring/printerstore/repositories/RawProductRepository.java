package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.RawProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RawProductRepository extends CrudRepository<RawProduct, Integer> {
    List<RawProduct> getRawProductByType_Name(String productType);
}
