package com.example.carrental.services.impl;

import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public void create(int id, Order order) {

    }

    @Override
    public void update(int id, Order order) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getById(int id) {
        return null;
    }

    @Override
    public List<User> getUser(Order order) {
        return null;
    }

    @Override
    public List<Order> getActive() {
        return null;
    }

}
