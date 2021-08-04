package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCatalogController {
    ProductCatalogService productCatalogService;

    @Autowired
    ProductCatalogController(ProductCatalogService productCatalogService){
        this.productCatalogService = productCatalogService;
    }

    @GetMapping( "/products")
    Iterable<Product> getProductsByType(@RequestParam String typeName){
        System.out.println(typeName);
        return this.productCatalogService.getProductByType(typeName);
    }

    @GetMapping( "/products/all")
    Iterable<Product> getProducts(){
        return this.productCatalogService.findAll();
    }

    @PostMapping( "/products")
    Product getProducts(@RequestBody Product product){
        return this.productCatalogService.create(product);
    }

    @DeleteMapping( "/products/{id}")
    void getProducts(@PathVariable int id){
        this.productCatalogService.delete(id);
    }
}
