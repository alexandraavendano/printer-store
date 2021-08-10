package com.practicespring.printerstore.exceptions;

public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(Long id) {
        super("Could not found image " + id);
    }
}



