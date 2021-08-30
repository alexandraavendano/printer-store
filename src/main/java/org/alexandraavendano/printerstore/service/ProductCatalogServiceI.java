package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.models.ProductType;

import java.util.Optional;

public interface ProductCatalogServiceI {
    Product create(Product product);

    Optional<Product> findBy(Long id);

    Iterable<Product> findAll();

    Iterable<Product> getProductByType(String productType);

    Iterable<Product> findByPartialQuery(String partialQuery);

    Iterable<ProductType> getProductTypes();

    void delete(Long id);
}