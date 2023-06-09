package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.models.Order;
import com.example.carrental.models.Payment;
import com.example.carrental.models.User;
import com.example.carrental.services.*;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

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
    @PreAuthorize("hasRole('ROLE_USER')")
    public String newOrder(@Valid @ModelAttribute("order")Order order, @RequestParam("orderLocation") String locationName) {

        order.setLocation(locationService.getLocation(locationName).get(0));


        Car tempCar = carService.getById(1);
        User user = userService.getCurrentUser();
        Payment tempPayment = paymentService.getById(1);
        order.setCar(tempCar);
        order.setUser(user);
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

    @GetMapping(value = "search-results")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String showSearch(Model model){

        int locationId = orderService.getLatestOrder().getLocation().getId();

        List<Car> carList = carService.getAvailableForLocationId(true, locationId);
        model.addAttribute("cars", carList);

        return "car-results";
    }

    @PostMapping(value = "/select-car")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String carSelect(@RequestParam("car-id") int carId) {

        Order order = orderService.getLatestOrder();

        Car car = carService.getById(carId);

        order.setCar(car);

        orderService.update(order.getId(), order);

        return "redirect:/select-payment";
    }

    @GetMapping(value = "select-payment")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String paymentSelect() {

        Order order = orderService.getLatestOrder();

        order.setPrice(orderService.calculateTotalPrice(order));

        orderService.update(order.getId(), order);

        return "payment";
    }

    @GetMapping(value = "cash")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String cashCheckout(Model model) {

        Order order = orderService.getLatestOrder();

        Payment payment = new Payment();
        payment.setDate(LocalDate.now());
        payment.setPrice(order.getPrice());
        payment.setCompleted(false);

        paymentService.create(payment);

        order.setPayment(payment);

        order.setPaymentType(1);

        orderService.update(order.getId(), order);

        model.addAttribute("order", order);

        return "cash";
    }

    @GetMapping(value = "checkout")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String cardCheckout(Model model) {

        Order order = orderService.getLatestOrder();

        model.addAttribute("order", order);

        return "checkout";
    }

    @PostMapping(value = "/checkout")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String cardCheckout() {

        Order order = orderService.getLatestOrder();

        Payment payment = new Payment();
        payment.setDate(LocalDate.now());
        payment.setPrice(order.getPrice());
        payment.setCompleted(true);

        paymentService.create(payment);

        order.setPayment(payment);
        order.setPaymentType(2);
        orderService.update(order.getId(), order);

        return "redirect:/success";
    }

    @GetMapping(value = "success")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String confirmOrder() {

        Order order = orderService.getLatestOrder();

        Car car = carService.getById(order.getCar().getId());
        car.setAvailable(false);
        carService.update(car.getId(), car);

        return "success";
    }

}
