package org.alexandraavendano.printerstore.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("Could not find employee " + id);
    }
}
