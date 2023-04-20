package com.example.carrental.services;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;

import java.util.List;

public interface OrderService {


    void create(int id, Order order);

    void update(int id, Order order);

    void delete(Order order);

    List<Order> getAll();

    List<Order> getById(int id);

    List<User> getUser(Order order);

    List<Order> getActive();

}
