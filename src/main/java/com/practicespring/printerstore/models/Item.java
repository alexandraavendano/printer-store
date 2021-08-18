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
    private double price;
    private double subtotal;

    @OneToOne
    private State printState;

    @OneToOne
    private Image image;

    @OneToMany
    private List<CustomizableProduct> products;

    @OneToMany
    private List<RawProduct> rawProducts;

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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public State getPrintState() {
        return printState;
    }

    public void setPrintState(State printState) {
        this.printState = printState;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<CustomizableProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CustomizableProduct> products) {
        this.products = products;
    }

    public List<RawProduct> getRawProducts() {
        return rawProducts;
    }

    public void setRawProducts(List<RawProduct> rawProducts) {
        this.rawProducts = rawProducts;
    }
}
