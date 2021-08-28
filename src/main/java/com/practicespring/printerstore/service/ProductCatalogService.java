package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.models.ProductType;
import com.practicespring.printerstore.repositories.ProductRepository;
import com.practicespring.printerstore.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogService {

    ProductRepository productRepository;
    ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductCatalogService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public Product create(Product product) {
        ProductType pt = product.getType();
        if(productTypeRepository.findByNameAndAndSubType(pt.getName(), pt.getSubType()).isEmpty()){
            productTypeRepository.save(pt);
        }
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

    public Iterable<ProductType> getProductTypes(){
        return productTypeRepository.findAll();
    }
}
