package com.practicespring.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class Item {

    @Id
    private int id;
    private double height;
    private double width;
    private double price; //Total price per item including customizations
    private int quantity;

    @OneToOne
    private State state;

    @OneToOne
    private Image image;

    @OneToMany
    private List<Product> customizations;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public State getState() {
        return state;
    }

    public void setState(State printState) {
        this.state = printState;
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

    public void setCustomizations(List<Product> products) {
        this.customizations = products;
    }
}
