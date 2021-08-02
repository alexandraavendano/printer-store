package com.practicespring.printerstore.models;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private double price;

    @ManyToOne
    private ProductType type; //Structure, Design Service, Print Service, DeliveryService

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}