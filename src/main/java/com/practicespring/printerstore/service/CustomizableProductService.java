package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.CustomizableProduct;
import com.practicespring.printerstore.repositories.CustomizableProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizableProductService {

    CustomizableProductRepository customizableProductRepository;

    @Autowired
    public CustomizableProductService(CustomizableProductRepository productRepository) {
        this.customizableProductRepository = productRepository;
    }

    public CustomizableProduct create(CustomizableProduct product) {
        return customizableProductRepository.save(product);
    }

    public void delete(int id) {
        customizableProductRepository.deleteById(id);
    }

    public Optional<CustomizableProduct> findBy(int id) {
        return customizableProductRepository.findById(id);
    }

    public Iterable<CustomizableProduct> findAll() {
        return customizableProductRepository.findAll();
    }

    public List<CustomizableProduct> getProductByType(String productType){
        return customizableProductRepository.getCustomizableProductByType_Name(productType);
    }
}
