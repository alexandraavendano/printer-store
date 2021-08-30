package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.exceptions.ClientNotFoundException;
import org.alexandraavendano.printerstore.exceptions.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClientNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    CustomError clientNotFoundHandler(ClientNotFoundException ex) {
        return new CustomError(HttpStatus.NOT_FOUND.value() , ex.getMessage());
    }
}
