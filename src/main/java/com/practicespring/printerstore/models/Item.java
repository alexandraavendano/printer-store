package com.practicespring.printerstore.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int id;
    private String height;
    private String width;
    private double price; //Total price per item including customizations
    private int quantity;

    @OneToOne
    private State state;

    @OneToOne
    private Image image;

    @ManyToMany
    private List<Product> customizations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Product> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<Product> customizations) {
        this.customizations = customizations;
    }
}
