package org.alexandraavendano.printerstore.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.models.ProductType;
import org.alexandraavendano.printerstore.repositories.ProductRepository;
import org.alexandraavendano.printerstore.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogService implements ProductCatalogServiceI {

    ProductRepository productRepository;
    ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductCatalogService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public Product create(Product product) {
        ProductType pt = product.getType();
        if(productTypeRepository.findByNameAndSubType(pt.getName(), pt.getSubType()).isEmpty()){
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

    public Iterable<Product> getProductByType(String productType){
        return productRepository.getProductByType_Name(productType);
    }

    public Iterable<Product> findByPartialQuery(String partialQuery) {
        Iterable<Product> productByName = productRepository.getProductByNameIsContaining(partialQuery);
        Iterable<Product> productBySubtype = productRepository.getProductByType_SubTypeIsContaining(partialQuery);
        Iterable<Product> productBySubtypeName = productRepository.getProductByType_NameIsContaining(partialQuery);
        Iterable<Product> products = Iterables.concat(productByName,productBySubtype,productBySubtypeName);
        return Sets.newHashSet(products);
    }

    public Iterable<ProductType> getProductTypes(){
        return productTypeRepository.findAll();
    }
}
