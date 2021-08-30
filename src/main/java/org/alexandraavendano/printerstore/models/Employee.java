package org.alexandraavendano.printerstore.models;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Employee extends Person {
    private String jobTitle;

    public Employee(){
        super();
        this.setRole(new Role("ROLE_EMPLOYEE"));
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getJobTitle(), employee.getJobTitle())
                && getEmail().equals(employee.getEmail())
                && getFirstName().equals(employee.getFirstName())
                && getLastName().equals(employee.getLastName())
                && getPassword().equals(employee.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getJobTitle());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
