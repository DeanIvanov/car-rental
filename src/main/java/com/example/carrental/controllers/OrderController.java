package com.example.carrental.controllers;

import com.example.carrental.services.OrderService;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



}
