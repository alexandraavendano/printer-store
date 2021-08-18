package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.RawProduct;
import com.practicespring.printerstore.repositories.RawProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RawProductService {

    RawProductRepository rawProductRepository;

    @Autowired
    public RawProductService(RawProductRepository productRepository) {
        this.rawProductRepository = productRepository;
    }

    public RawProduct create(RawProduct product) {
        return rawProductRepository.save(product);
    }

    public void delete(int id) {
        rawProductRepository.deleteById(id);
    }

    public Optional<RawProduct> findBy(int id) {
        return rawProductRepository.findById(id);
    }

    public Iterable<RawProduct> findAll() {
        return rawProductRepository.findAll();
    }

    public List<RawProduct> getProductByType(String productType){
        return rawProductRepository.getRawProductByType_Name(productType);
    }
}


