package org.alexandraavendano.printerstore.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    private String height;
    private String width;
    private double price;
    private int quantity;
    private String designNotes;

    @OneToOne
    private State state;

    @OneToOne
    private Image image;

    @ManyToMany
    private List<Product> customizations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDesignNotes() {
        return designNotes;
    }

    public void setDesignNotes(String designNotes) {
        this.designNotes = designNotes;
    }
}
