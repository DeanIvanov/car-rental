package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.Payment;
import com.example.carrental.models.User;
import com.example.carrental.services.LocationService;
import com.example.carrental.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private OrderService orderService;
    private LocationService locationService;

    public OrderController(OrderService orderService, LocationService locationService) {
        this.orderService = orderService;
        this.locationService = locationService;
    }

    @PostMapping(value = "/search")
    public String newOrder(@Valid @ModelAttribute("order")Order order, @RequestParam("orderLocation") String locationName) {
        order.setLocation(locationService.getLocation(locationName).get(0));

        order.setCar(new Car());
        order.setUser(new User());
        order.setStartDate(order.getStartDate());
        order.setEndDate(order.getEndDate());
        order.setLocation(locationService.getLocation(locationName).get(0));
        order.setPrice(0);
        order.setPaymentType(0);
        order.setPayment(new Payment());
        order.setActive(false);
        order.setCompleted(false);

        orderService.create(order.getId(), order);

        return "search";
    }

}
