package com.example.carrental.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
    private LocalDate date;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "completed")
    @NotNull
    private boolean completed;

//    @NotNull
//    @NotBlank
//    @Size(min = 4, max = 20, message = "Name must be between 5 and 40 characters")
//    private String name;
//
//    @NotNull
//    @NotBlank
//    @Size(min = 16, max = 16, message = "Card number must be exactly 16 digits")
//    private String cardNumber;
//
//    @NotNull
//    @NotBlank
//    private String expiryDate;
//
//    @NotNull
//    private int cvc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
//    public void setCardNumber(String cardNumber) {
//        this.cardNumber = cardNumber;
//    }
//
//    public String getExpiryDate() {
//        return expiryDate;
//    }
//
//    public void setExpiryDate(String expiryDate) {
//        this.expiryDate = expiryDate;
//    }
//
//    public int getCvc() {
//        return cvc;
//    }
//
//    public void setCvc(int cvc) {
//        this.cvc = cvc;
//    }

}
