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
@Table(name = "users")
public class User {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @PositiveOrZero(message = "ID should be positive or zero")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15")
    private String name;

    @Column(name = "surname")
    @NotNull
    @NotBlank
    @Size(min = 3, max = 20, message = "Surname must be between 3 and 20")
    private String surname;

    @NotNull
    @Size(min = 7, max = 50, message = "Email should be between 7 and 50")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 5, max = 68, message = "Password must be between 5 and 68")
    private String password;

    @Column(name = "phone")
    @Size(min = 10, max = 13, message = "Phone number should be between 10 and 13")
    private String phone;

    @Column(name = "address")
    @NotNull
    @Size(min = 10, max = 100, message = "Password must be between 10 and 100")
    private String address;

    @Column(name = "dob")
    @DateTimeFormat
    private Date dob;

    @Column(name = "license_number")
    @NotNull
    @Size(min = 6, max = 8, message = "License number must be between 6 and 8")
    private String licenseNumber;

    @Column(name = "license_category")
    @NotNull
    @Size(min = 1, max = 2, message = "License category must be between 1 and 2")
    private String licenseCategory;

    @Column(name = "blocked")
    private boolean blocked;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

}