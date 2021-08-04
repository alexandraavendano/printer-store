package com.practicespring.printerstore.models;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {
    private String jobTitle;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
