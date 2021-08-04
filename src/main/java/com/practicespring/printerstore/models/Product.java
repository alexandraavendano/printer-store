package com.practicespring.printerstore.models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    private int id;

    private String name;
    private String description;
    private double price;

    @OneToOne(cascade = CascadeType.MERGE)
    private Image image;

    @ManyToOne(cascade = CascadeType.MERGE)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
