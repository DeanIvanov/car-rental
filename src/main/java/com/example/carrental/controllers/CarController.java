package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.services.CarService;
import com.example.carrental.services.LocationService;
import com.example.carrental.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarController {

    private CarService carService;
    private LocationService locationService;


    @Autowired
    public CarController(CarService carService, LocationService locationService) {
        this.carService = carService;
        this.locationService = locationService;
    }

    @GetMapping(value = "/car-register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showRegister(){

        return "add-car";
    }

    @PostMapping(value = "/car-register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String registerUser(@Valid @ModelAttribute("car") Car car, @RequestParam("locationName") String locationName) {

        car.setLocation(locationService.getLocation(locationName).get(0));

        carService.create(car.getId(), car);

        return "index";
    }

}