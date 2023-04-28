package com.example.carrental.controllers;

import com.example.carrental.models.Authorities;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    public HomeController() {
    }

    @GetMapping("/")
    public String showHomePage() {

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
