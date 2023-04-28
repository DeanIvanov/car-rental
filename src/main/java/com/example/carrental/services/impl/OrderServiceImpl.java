package com.example.carrental.services.impl;

import com.example.carrental.exceptions.DuplicateEntityException;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.repositories.OrderRepository;
import com.example.carrental.services.OrderService;
import com.example.carrental.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

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
        if(orderRepository.existsByUserIdAndActiveAndCompleted(order.getUser().getId(), true, false)){
            throw new DuplicateEntityException(String.format("Active order with user %s already exists!", order.getUser().getUsername()));
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
        newOrder.setCompleted(false);
        newOrder.setActive(true);

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

    @Override
    public Order getLatestOrder() {
        return orderRepository.findTopByOrderByIdDesc();
    }

    @Override
    public double calculateTotalPrice(Order order) {
        long totalDays = Math.abs(ChronoUnit.DAYS.between(order.getStartDate(),order.getEndDate()));
        if (totalDays < 1) {
            totalDays = 1;
        }
        return order.getCar().getPrice() * totalDays;
    }

    @Override
    public Optional<Order> getActiveOrderForUser(int id) {
        return orderRepository.findOrderByActiveAndCompletedAndUserId(true, false, id);
    }


}
