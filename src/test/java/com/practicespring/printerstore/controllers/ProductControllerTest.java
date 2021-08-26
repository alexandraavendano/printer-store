package com.practicespring.printerstore.controllers;
import static org.assertj.core.api.Assertions.assertThat;

import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.models.ProductType;
import com.practicespring.printerstore.service.ProductCatalogService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductCatalogService productCatalogService;

    @Test
    public void returnAllProducts() throws Exception {
        ProductType productType = new ProductType();
        productType.setName("ProductTypeName");
        productType.setSubType("ProductSubType");
        Product product = new Product();
        product.setName("ProductName");
        product.setDescription("Short Description");
        product.setPrice(3.0);
        product.setType(productType);
        productCatalogService.create(product);

        Iterable<Product> expectedProduct = new ArrayList<>(Arrays.asList(product));

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/products/all", String.class)).contains("Short Description");
    }
}