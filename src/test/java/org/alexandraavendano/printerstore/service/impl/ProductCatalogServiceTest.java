package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.models.ProductType;
import org.alexandraavendano.printerstore.repositories.ProductTypeRepository;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProductCatalogServiceTest {

    @Autowired
    ProductCatalogService productCatalogService;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Transactional
    @ParameterizedTest
    @ValueSource(strings = {"Mu", "w", "Ra"})
    public void createAndFind(String partialQuery){
        ProductType productType = new ProductType();
        productType.setName("Material");
        productType.setSubType("Raw");
        productTypeRepository.save(productType);

        Product product = new Product();
        product.setDescription("short description");
        product.setPrice(3.0);
        product.setName("Mug");
        product.setId(1L);
        product.setType(productType);
        Product expectedProduct = productCatalogService.create(product);

        Iterable<Product> actualProducts = productCatalogService.findByPartialQuery(partialQuery);
        Iterable<Product> actualProducts3 = productCatalogService.getProductByType(productType.getName());
        assertEquals(expectedProduct, actualProducts.iterator().next());
        assertEquals(expectedProduct, actualProducts3.iterator().next());
    }
}
