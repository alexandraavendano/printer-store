package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Employee;

import java.util.Optional;

public interface EmployeeServicesI {
    Employee create(Employee employee);

    Optional<Employee> findByEmail(String email);

    Iterable<Employee> findByPartial(String partialQuery);

    Iterable<Employee> findAll();

    void delete(String email);
}
