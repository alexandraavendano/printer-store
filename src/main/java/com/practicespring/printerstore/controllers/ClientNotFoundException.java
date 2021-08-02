package com.practicespring.printerstore.controllers;

public class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(String id) {
        super("Could not find client " + id);
    }
}
