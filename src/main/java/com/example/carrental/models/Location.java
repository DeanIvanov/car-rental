package com.example.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {


    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive or zero")
    private int id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15")
    private String name;

    @Column(name = "phone")
    @Size(min = 10, max = 13, message = "Phone number should be between 10 and 13")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Car> carList;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private List<Order> orderList;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}
