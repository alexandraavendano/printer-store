package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.ClientNotFoundException;
import com.practicespring.printerstore.exceptions.CustomError;
import com.practicespring.printerstore.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    CustomError employeeNotFoundHandler(EmployeeNotFoundException ex) {
        return new CustomError(HttpStatus.NOT_FOUND.value() , ex.getMessage());
    }
}
