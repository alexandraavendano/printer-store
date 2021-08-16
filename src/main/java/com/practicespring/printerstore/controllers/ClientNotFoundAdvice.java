package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ClientNotFoundException;
import com.practicespring.printerstore.exceptions.CustomError;
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
