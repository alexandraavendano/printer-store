package com.practicespring.printerstore.service;

import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(String email) {
        employeeRepository.deleteById(email);
    }

    public Optional<Employee> findBy(String email) {
        return employeeRepository.findById(email);
    }
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
