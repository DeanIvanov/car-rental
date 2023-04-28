package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.services.CarService;
import com.example.carrental.services.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import com.example.carrental.services.UserService;
import com.example.carrental.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
public class UserController {

    private UserService userService;
    private OrderService orderService;
    private CarService carService;

    public UserController(UserService userService, OrderService orderService, CarService carService) {
        this.userService = userService;
        this.orderService = orderService;
        this.carService = carService;
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userPanel(Model model) {

        User user = userService.getCurrentUser();
        Optional<Order> order = orderService.getActiveOrderForUser(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("order", order);

        return "profile";
    }

    @GetMapping("user/order")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String userOrder(Model model) {

        User user = userService.getCurrentUser();
        Optional<Order> order = orderService.getActiveOrderForUser(user.getId());

        if(order.isPresent()) {
            model.addAttribute("order", order);
            return "user-order";
        }

        return "profile";
    }

}
