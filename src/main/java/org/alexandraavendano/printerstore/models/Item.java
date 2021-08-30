package org.alexandraavendano.printerstore.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Double.compare(item.getPrice(), getPrice()) == 0 && getQuantity() == item.getQuantity() && Objects.equals(getId(), item.getId()) && Objects.equals(getHeight(), item.getHeight()) && Objects.equals(getWidth(), item.getWidth()) && Objects.equals(getDesignNotes(), item.getDesignNotes()) && Objects.equals(getState(), item.getState()) && Objects.equals(getImage(), item.getImage()) && Objects.equals(getCustomizations(), item.getCustomizations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHeight(), getWidth(), getPrice(), getQuantity(), getDesignNotes(), getState(), getImage(), getCustomizations());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", designNotes='" + designNotes + '\'' +
                ", state=" + state +
                ", image=" + image +
                ", customizations=" + customizations +
                '}';
    }

}
