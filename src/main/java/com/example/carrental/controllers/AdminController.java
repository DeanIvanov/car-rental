package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.User;
import com.example.carrental.services.CarService;
import com.example.carrental.services.OrderService;
import com.example.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    private CarService carService;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public AdminController(CarService carService, OrderService orderService, UserService userService) {
        this.carService = carService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdmin() {

        return "admin";
    }

    @GetMapping("admin/cars")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showCars(Model model) {

        List<Car> carList = carService.getAll();

        model.addAttribute("cars", carList);

        return "admin-cars";
    }

    @GetMapping("admin/cars/available")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAvailableCars(Model model) {

        List<Car> carList = carService.getByAvailability(true);

        model.addAttribute("cars", carList);

        return "admin-cars-available";
    }

    @GetMapping("admin/orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showOrders(Model model) {

        List<Order> orderList = orderService.getAll();

        model.addAttribute("orders", orderList);

        return "admin-orders";
    }

    @GetMapping("admin/orders/active")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showActiveOrders(Model model) {

        List<Order> orderList = orderService.getActive();

        model.addAttribute("orders", orderList);

        return "admin-orders-active";
    }

    @GetMapping("admin/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUsers(Model model) {

        List<User> userList = userService.getAll();

        model.addAttribute("users", userList);

        return "admin-users";
    }

}
