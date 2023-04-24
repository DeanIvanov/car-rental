package com.example.carrental.services;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;

import java.util.Date;
import java.util.List;

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

    List<Order> getByDate(Date start, Date end);

}
