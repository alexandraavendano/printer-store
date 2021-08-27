package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ProductNotFoundException;
import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.models.ProductType;
import com.practicespring.printerstore.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCatalogController {

    ProductCatalogService productCatalogService;

    @Autowired
    ProductCatalogController(ProductCatalogService productCatalogService){
        this.productCatalogService = productCatalogService;
    }

    @GetMapping( "/all")
    Iterable<Product> getProducts(){
        return this.productCatalogService.findAll();
    }

    @GetMapping( "")
    Iterable<Product> getProductsByType(@RequestParam String typeName){
        return this.productCatalogService.getProductByType(typeName);
    }

    @GetMapping( "/productTypes")
    Iterable<ProductType> getProductTypes(){
        return this.productCatalogService.getProductTypes();
    }

    @GetMapping( "/{id}")
    Product getProductsByType(@PathVariable Long id){
        return this.productCatalogService.findBy(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping( "")
    Product getProducts(@RequestBody Product product){
        return this.productCatalogService.create(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping( "/{id}")
    void getProducts(@PathVariable Long id){
        this.productCatalogService.delete(id);
    }
}