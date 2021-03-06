package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.exceptions.ProductNotFoundException;
import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.models.ProductType;
import org.alexandraavendano.printerstore.service.impl.ProductCatalogService;
import org.alexandraavendano.printerstore.service.ProductCatalogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCatalogController {

    ProductCatalogServiceI productCatalogService;

    @Autowired
    ProductCatalogController(ProductCatalogService productCatalogService){
        this.productCatalogService = productCatalogService;
    }

    @GetMapping("/all")
    Iterable<Product> getAll(@RequestParam Optional<String> query){
        if(query.isPresent()) {
            return productCatalogService.findByPartialQuery(query.get());
        } else {
            return productCatalogService.findAll();
        }
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