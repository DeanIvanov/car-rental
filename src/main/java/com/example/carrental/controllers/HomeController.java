package com.example.carrental.controllers;

import com.example.carrental.models.Authorities;
import com.example.carrental.models.Car;
import com.example.carrental.models.Location;
import com.example.carrental.services.CarService;
import com.example.carrental.services.LocationService;
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
    private LocationService locationService;

    public HomeController(CarService carService, LocationService locationService) {
        this.carService = carService;
        this.locationService = locationService;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {

        List<Car> carList = carService.getByAvailability(true);
        List<Location> locationList = locationService.getAll();

        model.addAttribute("cars", carList);
        model.addAttribute("locations", locationList);

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
