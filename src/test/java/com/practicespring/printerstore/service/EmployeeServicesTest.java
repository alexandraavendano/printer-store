package com.practicespring.printerstore.service;

import com.google.common.collect.ImmutableList;
import com.practicespring.printerstore.models.Employee;
import com.practicespring.printerstore.models.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServicesTest {

    @Autowired
    private EmployeeServices employeeServices;

    @Test
    public void getAllByEmailIsContaining(){
        Role role = new Role();
        role.setName("ROLE_EMPLOYEE");
        Employee employee = new Employee();
        employee.setEmail("employee5@test.com");
        employee.setFirstName("employeeName");
        employee.setLastName("employeeLastName");
        employee.setRole(role);
        employee.setJobTitle("designer");
        employee.setPassword("secretPassword");
        employeeServices.create(employee);

        Iterable<Employee> expectedList1 = employeeServices.findByPartial("em");
        assertEquals(employee, expectedList1.iterator().next());

        List<Employee> expectedList2 = ImmutableList.copyOf(employeeServices.findByPartial("xyz"));
        assertTrue(expectedList2.isEmpty());
    }

}
