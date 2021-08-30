package org.alexandraavendano.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Client extends Person {

    @OneToMany
    private List<Order> orders;

    @OneToMany
    public List<Payment> creditCards;

    public Client(){
        super();
        this.setRole(new Role("ROLE_CLIENT"));
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Payment> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<Payment> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(getOrders(), client.getOrders()) && Objects.equals(getCreditCards(), client.getCreditCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrders(), getCreditCards());
    }

    @Override
    public String toString() {
        return "Client{" +
                "orders=" + orders +
                ", creditCards=" + creditCards +
                '}';
    }
}

