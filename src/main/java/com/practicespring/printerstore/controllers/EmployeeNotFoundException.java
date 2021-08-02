package com.practicespring.printerstore.controllers;

public class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(String id) {
        super("Could not fiend employee " + id);
    }
}
