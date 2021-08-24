package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogService {

    ProductRepository productRepository;

    @Autowired
    public ProductCatalogService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findBy(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> getProductByType(String productType){
        return productRepository.getProductByType_Name(productType);
    }
}
