package com.example.carrental.controllers;

import org.springframework.stereotype.Controller;
import com.example.carrental.services.UserService;
import com.example.carrental.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("user")
//    public String userPanel(Model model) {
//
//        User user = userService.getCurrentUser();
//
//        model.addAttribute("user", user);
//
//        return "profile";
//    }

}
