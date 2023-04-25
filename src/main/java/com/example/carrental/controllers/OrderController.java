package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.Payment;
import com.example.carrental.models.User;
import com.example.carrental.services.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private OrderService orderService;
    private LocationService locationService;
    private CarService carService;
    private UserService userService;
    private PaymentService paymentService;

    public OrderController(OrderService orderService, LocationService locationService, CarService carService, UserService userService, PaymentService paymentService) {
        this.orderService = orderService;
        this.locationService = locationService;
        this.carService = carService;
        this.userService = userService;
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/search")
    public String newOrder(@Valid @ModelAttribute("order")Order order, @RequestParam("orderLocation") String locationName) {
        order.setLocation(locationService.getLocation(locationName).get(0));

        Car tempCar = carService.getById(1);
        User tempUser = userService.getById(1);
        Payment tempPayment = paymentService.getById(1);
        order.setCar(tempCar);
        order.setUser(tempUser);
        order.setStartDate(order.getStartDate());
        order.setEndDate(order.getEndDate());
        order.setLocation(locationService.getLocation(locationName).get(0));
        order.setPrice(0);
        order.setPaymentType(0);
        order.setPayment(tempPayment);
        order.setActive(false);
        order.setCompleted(false);

        orderService.create(order.getId(), order);

        return "redirect:/search-results";
    }

}
