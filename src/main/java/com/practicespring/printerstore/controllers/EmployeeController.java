package com.practicespring.printerstore.controllers;

import com.practicespring.printerstore.exceptions.EmployeeNotFoundException;
import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeServices employeeServices;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.employeeServices = employeeServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("")
    Iterable<Employee> getAll(){
        return employeeServices.findAll();
    }

    @GetMapping("/{id}")
    Employee get(@PathVariable String id){
        return employeeServices.findBy(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/signup")
    Employee create(@RequestBody Employee newEmployee){
        newEmployee.setPassword(bCryptPasswordEncoder.encode(newEmployee.getPassword()));
        return employeeServices.create(newEmployee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        employeeServices.delete(id);
    }
}
