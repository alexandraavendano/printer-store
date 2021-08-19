package com.practicespring.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductType {

    private String name;
    @Id
    private String subType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }
}
