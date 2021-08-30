package org.alexandraavendano.printerstore.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Client extends Person {

    @ManyToMany
    private List<Order> orders;

    public Client(){
        super();
        this.setRole(new Role("ROLE_CLIENT"));
    }

    public List<Order> getOrders() {
        return orders;
    }

    @OneToMany
    public List<Payment> creditCards;

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
        return Objects.equals(orders, client.orders) && Objects.equals(creditCards, client.creditCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orders, creditCards);
    }
}

