package org.alexandraavendano.printerstore.service.impl;

import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.models.ProductType;
import org.alexandraavendano.printerstore.repositories.ProductTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatalogServiceTest {

    @Autowired
    ProductCatalogService productCatalogService;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Test
    @Transactional
    public void createAndFind(){
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

        Iterable<Product> actualProducts = productCatalogService.findByPartialQuery("Mu");
        Iterable<Product> actualProducts2 = productCatalogService.findByPartialQuery("w");
        Iterable<Product> actualProducts3 = productCatalogService.getProductByType(productType.getName());
        assertEquals(expectedProduct, actualProducts.iterator().next());
        assertEquals(expectedProduct, actualProducts2.iterator().next());
        assertEquals(expectedProduct, actualProducts3.iterator().next());
    }
}
