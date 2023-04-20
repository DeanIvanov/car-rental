package com.example.carrental.services;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface OrderService {


    void create(int id, Order order);

    void update(int id, Order order);

    void delete(Order order);

    void completeOrder(Order order);

    List<Order> getAll();

    Order getById(int id);

    List<Order> getByCurrentUser();
    List<Order> getByUser(User user);

    List<Order> getByCar(Car car);

    List<Order> getActive();

    List<Order> getByDate(Date start, Date end);

}
