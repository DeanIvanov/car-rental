package com.example.carrental.controllers;

import com.example.carrental.models.Authorities;
import com.example.carrental.models.Car;
import com.example.carrental.services.CarService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {

        List<Car> carList = carService.getByAvailability(true);

        model.addAttribute("cars", carList);

        return "index";
    }

    @PostMapping("/authenticate")
    public String showRegisterConfirmation() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authorities authorities = new Authorities();
        authorities.getAuthority().equals(authentication);

        return "redirect:/index";
    }

    @GetMapping(value = "/login")
    public String showLogin(){

        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }

}
