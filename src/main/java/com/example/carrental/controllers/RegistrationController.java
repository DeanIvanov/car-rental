package com.example.carrental.controllers;

import com.example.carrental.models.User;
import com.example.carrental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String showRegister(){
        return "register";

    }

    @PostMapping(value = "/register")
    public String registerUser(@Valid @ModelAttribute("user")User user) {
        userService.create(user.getId(),user);
        return "index";

    }

//    @GetMapping("user/details")
//    public String editUser(Model model) {
//        User user = userService.getCurrentUser();
//        model.addAttribute("user", user);
//        return "index";
//
//    }



}
