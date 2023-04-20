package com.example.carrental.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {


    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive or zero")
    private int id;

    @Column(name = "date")
    @DateTimeFormat
    private Date date;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "completed")
    @NotNull
    @NotBlank
    private boolean completed;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 20, message = "Name must be between 5 and 40 characters")
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 16, max = 16, message = "Card number must be exactly 16 digits")
    private int cardNumber;

    @DateTimeFormat
    private Date expiryDate;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 3, message = "Security code must be exactly 3 digits")
    private int cvc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

}
