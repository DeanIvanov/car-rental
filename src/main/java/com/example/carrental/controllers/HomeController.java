package com.example.carrental.controllers;

import com.example.carrental.models.Authorities;
import com.example.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomePage() {
        System.out.println(userService.encodePass("12345678"));
        return "index";
    }

    @PostMapping("/authenticate")
    public String showRegisterConfirmation() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Authorities authorities = new Authorities();
        authorities.getAuthority().equals(authentication);
        System.out.println(String.format("Logged in user: %s", userService.getCurrentUser().getEmail()));
        return "index";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
