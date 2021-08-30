package org.alexandraavendano.printerstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private String cardNumber;
    @NonNull
    private String cardHolderName;
    @NonNull
    private int year;
    @NonNull
    private int month;
    @NonNull
    private String cvv;

    @ManyToOne
    private Client client;

    @JsonIgnore
    public String getCompleteCardNumber() {
        return cardNumber;
    }

    public String getCardNumber() {
        return cardNumber.substring(12,16);
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @NonNull
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(@NonNull String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @JsonIgnore
    public String getCvv() {
        return cvv;
    }

    @JsonProperty
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return getYear() == payment.getYear() && getMonth() == payment.getMonth() && Objects.equals(getId(), payment.getId()) && Objects.equals(getCardNumber(), payment.getCardNumber()) && getCardHolderName().equals(payment.getCardHolderName()) && getCvv().equals(payment.getCvv()) && Objects.equals(getClient(), payment.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardNumber(), getCardHolderName(), getYear(), getMonth(), getCvv(), getClient());
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", cvv='" + cvv + '\'' +
                ", client=" + client +
                '}';
    }
}
