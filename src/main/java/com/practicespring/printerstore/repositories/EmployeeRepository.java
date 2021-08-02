package com.practicespring.printerstore.repositories;

import com.practicespring.printerstore.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
