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

    /*
    * Checks if there is an order for the current user in the database and saves the new order to the database
    * through the repository class.
    * */
    @Override
    public void create(int id, Order order) {
        if(orderRepository.existsByUserIdAndActiveAndCompleted(order.getUser().getId(), true, false)){
            throw new DuplicateEntityException(String.format("Active order with user %s already exists!", order.getUser().getUsername()));
        }
        orderRepository.save(order);
    }

    /*
    * Updates each property of an order object and saves it in the database through the repository class.
    * */
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

    /*
    * Deletes an order through the repository class.
    * */
    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    /*
    * Flips the completion status of an order in the database.
    * */
    @Override
    public void completeOrder(Order order) {
        if(order.isCompleted()){
            order.setCompleted(false);
        } else {
            order.setCompleted(true);
        }
        orderRepository.save(order);
    }

    /*
    * Gets a list of all order objects from the database.
    * */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /*
    * Gets a single order object by its ID from the database.
    * */
    @Override
    public Order getById(int id) {
        return orderRepository.getById(id);
    }

    /*
    * Gets a list of all order objects that belong to the searched user object.
    * */
    @Override
    public List<Order> getByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    /*
    * Gets a list of all order objects that belong to the searched user ID.
    * */
    @Override
    public List<Order> getByUserId(int id) {
        return orderRepository.findAllByUserId(id);
    }

    /*
    * Gets a list of all order objects that use the searched car ID.
    * */
    @Override
    public List<Order> getByCarId(int id) {
        return orderRepository.findAllByCarId(id);
    }

    /*
    * Gets a list of all order objects that are active
    * */
    @Override
    public List<Order> getActive() {
        return orderRepository.findAllByCompleted(false);
    }

    /*
    * Gets a list of all order objects that match the searched dates.
    * */
    @Override
    public List<Order> getByDate(LocalDate start, LocalDate end) {
        return orderRepository.findAllByStartDateBetweenOrEndDateBetween(start, end, start, end);
    }

    /*
    * Gets a single order object of the latest order.
    * */
    @Override
    public Order getLatestOrder() {
        return orderRepository.findTopByOrderByIdDesc();
    }

    /*
    * Calculates the total price of the order based on the total amount of days (rounded to full days) and
    * the cost of the car usage per day
    * */
    @Override
    public double calculateTotalPrice(Order order) {
        long totalDays = Math.abs(ChronoUnit.DAYS.between(order.getStartDate(),order.getEndDate()));
        if (totalDays < 1) {
            totalDays = 1;
        }
        return order.getCar().getPrice() * totalDays;
    }

    /*
    * Gets a single order object (if it exists) of the current active order of the currently logged-in user.
    * */
    @Override
    public Optional<Order> getActiveOrderForUser(int id) {
        return orderRepository.findOrderByActiveAndCompletedAndUserId(true, false, id);
    }


}
