package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> getProductByType_Name(String productType);
    Iterable<Product> getProductByNameIsContaining(String partialName);
    Iterable<Product> getProductByType_NameIsContaining(String partialTypeName);
    Iterable<Product> getProductByType_SubTypeIsContaining(String partialSubTypeName);
}