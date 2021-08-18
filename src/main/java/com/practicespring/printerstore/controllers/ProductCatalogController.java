package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ProductNotFoundException;
import com.practicespring.printerstore.models.CustomizableProduct;
import com.practicespring.printerstore.models.Product;
import com.practicespring.printerstore.models.RawProduct;
import com.practicespring.printerstore.service.CustomizableProductService;
import com.practicespring.printerstore.service.RawProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCatalogController {

    CustomizableProductService customizableProductService;
    RawProductService rawProductService;

    @Autowired
    ProductCatalogController(CustomizableProductService productCatalogService, RawProductService rawProductService){
        this.customizableProductService = productCatalogService;
        this.rawProductService = rawProductService;
    }

    @GetMapping( "/customizable/all")
    Iterable<CustomizableProduct> getCustomizableProducts(){
        return this.customizableProductService.findAll();
    }

    @GetMapping( "/customizable")
    Iterable<CustomizableProduct> getCustomizableProductByType(@RequestParam String typeName){
        return this.customizableProductService.getProductByType(typeName);
    }

    @GetMapping( "/customizable/{id}")
    Product getCustomizableProductById(@PathVariable int id){
        return this.customizableProductService.findBy(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    //TODO: Handle error when rawProduct or image doesn't exist
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping( "/customizable")
    Product saveCustomizableProduct(@RequestBody CustomizableProduct product){
        return this.customizableProductService.create(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping( "/customizable/{id}")
    void deleteCustomizableProduct(@PathVariable int id){
        this.customizableProductService.delete(id);
    }

    @GetMapping( "/raw/all")
    Iterable<RawProduct> getRawProducts(){
        return this.rawProductService.findAll();
    }

    @GetMapping( "/raw")
    Iterable<RawProduct> getRawProductsByType(@RequestParam String typeName){
        return this.rawProductService.getProductByType(typeName);
    }

    @GetMapping( "/raw/{id}")
    Product getRawProductBy(@PathVariable int id){
        return this.rawProductService.findBy(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    //TODO: Handle error when image doesn't exist
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping( "/raw")
    Product saveRawProduct(@RequestBody RawProduct product){
        return this.rawProductService.create(product);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping( "/raw/{id}")
    void deleteRawProduct(@PathVariable int id){
        this.rawProductService.delete(id);
    }
}