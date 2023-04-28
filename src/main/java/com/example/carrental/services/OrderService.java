package com.example.carrental.services;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {


    void create(int id, Order order);

    void update(int id, Order order);

    void delete(Order order);

    void completeOrder(Order order);

    List<Order> getAll();

    Order getById(int id);

//    List<Order> getByCurrentUser();

    List<Order> getByUser(User user);

    List<Order> getByUserId(int id);

    List<Order> getByCarId(int id);

    List<Order> getActive();

    List<Order> getByDate(LocalDate start, LocalDate end);

    Order getLatestOrder();

    double calculateTotalPrice(Order order);

    Optional<Order> getActiveOrderForUser(int id);

}
