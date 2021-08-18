package com.practicespring.printerstore.models;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private String specifications;
    private double price;

    @ManyToOne
    private ProductType type; //Structure, Design Service, Print Service, DeliveryService

    @ManyToMany
    private List<Image> images;

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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> image) {
        this.images = image;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
