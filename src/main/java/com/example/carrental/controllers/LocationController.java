package com.example.carrental.controllers;

import com.example.carrental.models.Location;
import com.example.carrental.services.LocationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(value = "/location-register")
    public String showRegister(){

        return "add-location";
    }

    @PostMapping(value = "/location-register")
    public String registerLocation(@Valid @ModelAttribute("location") Location location) {

        locationService.create(location);

        return "index";
    }

}
