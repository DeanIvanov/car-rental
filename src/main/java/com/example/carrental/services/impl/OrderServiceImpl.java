package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.services.OrderService;
import com.example.carrental.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        if(orderRepository.existsByCompletedAndUserId(false, order.getUser().getId())){
            throw new DuplicateEntityException(String.format("Active order with user %s already exists!", order.getUser().getEmail()));
        }
        orderRepository.save(order);
    }

    @Override
    public void update(int id, Order order) {
        Order newOrder = orderRepository.getById(id);
        newOrder.setCar(order.getCar());
        newOrder.setUser(order.getUser());
        newOrder.setStartDate(order.getStartDate());
        newOrder.setEndDate(order.getEndDate());
        newOrder.setPrice(order.getPrice());
        newOrder.setLocation(order.getLocation());
        newOrder.setPaymentType(order.getPaymentType());
        newOrder.setPayment(order.getPayment());
        newOrder.setCompleted(order.isCompleted());

        orderRepository.save(newOrder);
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

//    @Override
//    public List<Order> getByCurrentUser() {
//        return orderRepository.findAllByUser(userService.getCurrentUser());
//    }

    @Override
    public List<Order> getByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    @Override
    public List<Order> getByUserId(int id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public List<Order> getByCarId(int id) {
        return orderRepository.findAllByCarId(id);
    }

    @Override
    public List<Order> getActive() {
        return orderRepository.findAllByCompleted(false);
    }

    @Override
    public List<Order> getByDate(LocalDate start, LocalDate end) {
        return orderRepository.findAllByStartDateBetweenOrEndDateBetween(start, end, start, end);
    }

}
