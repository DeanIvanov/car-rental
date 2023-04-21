package com.example.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {


    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive or zero")
    private int id;

    @Column(name = "type")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 1, message = "Car type must be exactly 1 digit")
    private int type;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15")
    private String name;

    @Column(name = "model")
    @NotNull
    @NotBlank
    @Size(min = 4, max = 20, message = "Model must be between 4 and 20")
    private String model;

    @Column(name = "color")
    @NotNull
    @NotBlank
    @Size(min = 3, max = 15, message = "Color must be between 3 and 15")
    private String color;

    @Column(name = "transmission")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 1, message = "Transmission type must be exactly 1 digit")
    private int transmission;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "price")
    @NotNull
    private double price;

    @Column(name = "seats")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 1, message = "Seats amount must be exactly 1 digit")
    private int seats;

    @Column(name = "registration_number")
    @NotNull
    @NotBlank
    @Size(min = 6, max = 8, message = "Registration number must be between 4 and 8 characters")
    private String registrationNumber;

    @Column(name = "car_picture")
    private String carPicture;

    @Column(name = "service_date")
    @DateTimeFormat
    private Date serviceDate;

    @Column(name = "available")
    private boolean available;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<Order> orderList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransmission() {
        return transmission;
    }

    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCarPicture() {
        return carPicture;
    }

    public void setCarPicture(String carPicture) {
        this.carPicture = carPicture;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }



}
