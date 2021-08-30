package org.alexandraavendano.printerstore.repositories;

import org.alexandraavendano.printerstore.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Iterable<Employee> getAllByEmailIsContaining(String partialEmail);

    Iterable<Employee> getAllByFirstNameIsContaining(String partialName);

    Iterable<Employee> getAllByLastNameIsContaining(String partialLastName);

    Iterable<Employee> getAllByJobTitleIsContaining(String partialJobTitle);

    Iterable<Employee> getAllByRoleNameContains(String partialRole);
}