package org.alexandraavendano.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductType {

    @Id
    private String subType;
    private String name;

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
