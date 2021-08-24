package com.practicespring.printerstore.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not found product " + id);
    }
}
