package com.example.carrental.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive or zero")
    private int id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15")
    private String name;

    @Column(name = "surname")
    @NotBlank
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20")
    private String surname;

    @Column(name = "username")
    @NotNull
    @Size(min = 7, max = 50, message = "Email should be between 7 and 50")
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min = 5, max = 68, message = "Password must be between 5 and 68")
    private String password;

    @Column(name = "phone")
    @Size(min = 10, max = 13, message = "Phone number should be between 10 and 13")
    private String phone;

    @Column(name = "address")
    @Size(min = 10, max = 100, message = "Password must be between 10 and 100")
    private String address;

    @Column(name = "dob")
    @DateTimeFormat
    private LocalDate dob;

    @Column(name = "license_number")
    @Size(min = 6, max = 8, message = "License number must be between 6 and 8")
    private String licenseNumber;

    @Column(name = "license_category")
    @Size(min = 1, max = 2, message = "License category must be between 1 and 2")
    private String licenseCategory;

    @Column(name = "enabled")
    private boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}