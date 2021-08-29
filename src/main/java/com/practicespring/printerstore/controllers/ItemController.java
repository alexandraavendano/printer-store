package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ProductNotFoundException;
import com.practicespring.printerstore.models.Item;
import com.practicespring.printerstore.service.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/items")
public class ItemController {

    static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

    private final ItemServices itemServices;

    @Autowired
    public ItemController(ItemServices itemServices){
        this.itemServices = itemServices;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_EMPLOYEE')")
    @GetMapping("")
    Item getItem(@RequestParam Long id) {
        return itemServices.getById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_EMPLOYEE')")
    @PutMapping("")
    Item createClient(@RequestBody Item updatedItem) {
        LOGGER.log(Level.FINE, "Updating item");
        return itemServices.save(updatedItem);
    }
}
