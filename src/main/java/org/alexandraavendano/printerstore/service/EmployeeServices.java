package org.alexandraavendano.printerstore.service;

import com.google.common.collect.Iterables;

import com.google.common.collect.Sets;
import org.alexandraavendano.printerstore.models.Employee;
import org.alexandraavendano.printerstore.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServices implements EmployeeServicesI {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(String email) {
        employeeRepository.deleteById(email);
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findById(email);
    }

    public Iterable<Employee> findByPartial(String partialQuery) {
        Iterable<Employee> employeesByEmail = employeeRepository.getAllByEmailIsContaining(partialQuery);
        Iterable<Employee> employeesByFirstName = employeeRepository.getAllByFirstNameIsContaining(partialQuery);
        Iterable<Employee> employeesByLastName = employeeRepository.getAllByLastNameIsContaining(partialQuery);
        Iterable<Employee> employeesByJobTitle = employeeRepository.getAllByJobTitleIsContaining(partialQuery);
        Iterable<Employee> employeesByRoleTitle = employeeRepository.getAllByRoleNameContains(partialQuery);

        Iterable<Employee> employees = Iterables.concat(employeesByEmail, employeesByFirstName, employeesByLastName, employeesByJobTitle, employeesByRoleTitle);

        return Sets.newHashSet(employees);
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
