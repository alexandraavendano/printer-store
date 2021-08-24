package com.practicespring.printerstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.persistence.*;

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
}
