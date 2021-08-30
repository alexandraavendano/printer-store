package org.alexandraavendano.printerstore.controllers;

import org.alexandraavendano.printerstore.exceptions.EmployeeNotFoundException;
import org.alexandraavendano.printerstore.models.Employee;
import org.alexandraavendano.printerstore.service.EmployeeServices;
import org.alexandraavendano.printerstore.service.EmployeeServicesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeServicesI employeeServices;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.employeeServices = employeeServices;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("")
    Iterable<Employee> getAll(@RequestParam Optional<String> query){
        if(query.isPresent()) {
            return employeeServices.findByPartial(query.get());
        } else {
            return employeeServices.findAll();
        }
    }

    @GetMapping("/{id}")
    Employee getByExactEmail(@PathVariable String id){
        return employeeServices.findByEmail(id).orElseThrow(() -> new EmployeeNotFoundException(id));
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
