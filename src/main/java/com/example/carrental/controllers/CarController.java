package com.example.carrental.controllers;

import com.example.carrental.models.Car;
import com.example.carrental.services.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/car-register")
    public String showRegister(){
        return "index";
    }

    @PostMapping(value = "/car-register")
    public String registerUser(@Valid @ModelAttribute("car") Car car,
                               @RequestParam("file") MultipartFile multipart) {
        carService.create(car.getId(), car, multipart);
        return "registration-confirmation";
    }
}