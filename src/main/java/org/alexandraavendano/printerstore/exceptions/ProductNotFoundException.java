package org.alexandraavendano.printerstore.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id) {
        super("Could not found product " + id);
    }
}
