package com.example.carrental.services.impl;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.repositories.CarRepository;
import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.repositories.UserRepository;
import com.example.carrental.services.OrderService;
import com.example.carrental.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserService userService;


    public OrderServiceImpl(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    @Override
    public void create(int id, Order order) {

    }

    @Override
    public void update(int id, Order order) {

    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void completeOrder(Order order) {
        if(order.isCompleted()){
            order.setCompleted(false);
        } else {
            order.setCompleted(true);
        }
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getByCurrentUser() {
        return orderRepository.findAllByUser(userService.getCurrentUser());
    }

    @Override
    public List<Order> getByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    @Override
    public List<Order> getByCar(Car car) {
        return orderRepository.findAllByCar(car);
    }

    @Override
    public List<Order> getActive() {
        return orderRepository.findAllByCompleted(false);
    }

    @Override
    public List<Order> getByDate(Date start, Date end) {
        return orderRepository.findAllByStartDateBetweenOrEndDateBetween(start, end, start, end);
    }

}
