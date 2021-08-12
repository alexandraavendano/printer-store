package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.EmployeeNotFoundException;
import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.models.Role;
import com.practicespring.printerstore.service.EmployeeServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @GetMapping("/{id}")
    Employee get(@PathVariable String id){
        return employeeServices.findBy(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/signin")
    Employee create(@RequestBody Employee newEmployee){
        return employeeServices.create(newEmployee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        employeeServices.delete(id);
    }
}
