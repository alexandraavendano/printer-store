package org.alexandraavendano.printerstore.exceptions;

public class ImageNotCreatedException extends RuntimeException {
    public ImageNotCreatedException() {
        super("Could not created image");
    }
}
