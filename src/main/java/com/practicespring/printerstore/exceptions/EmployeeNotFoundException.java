package com.practicespring.printerstore.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("Could not fiend employee " + id);
    }
}
