package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.models.Role;
import com.practicespring.printerstore.service.EmployeeServices;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices){
        this.employeeServices = employeeServices;
    }

    @GetMapping("/employees/{id}")
    Employee get(@PathVariable String id){
        return employeeServices.findBy(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    Employee create(@RequestBody Employee newEmployee){
        Role role = new Role("employee");
        newEmployee.setRole(role);
        return employeeServices.create(newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    void delete(@PathVariable String id){
        employeeServices.delete(id);
    }
}
