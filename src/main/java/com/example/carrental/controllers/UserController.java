package com.example.carrental.controllers;

import com.example.carrental.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String showLogin(){
        return "sign-in";
    }



}
